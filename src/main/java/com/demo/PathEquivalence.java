package com.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

/** CWE-41 — Path Equivalence. An extension check is bypassed by equivalent forms
 * (trailing dot/space, './'). Real vuln; NO finding = FALSE NEGATIVE. */
public class PathEquivalence {
    private static final String BASE = "/srv/app/data/";

    public InputStream get(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");   // SOURCE
        if (name.endsWith(".txt")) {               // naive allowlist by extension
            return new FileInputStream(BASE + name);  // "secret.conf/./x.txt" etc bypasses → CWE-41
        }
        throw new SecurityException("blocked");
    }
}
