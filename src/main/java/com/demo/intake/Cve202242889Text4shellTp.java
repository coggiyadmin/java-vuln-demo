package com.demo.intake;
// CVE-2022-42889 (Text4Shell) — Apache Commons Text StringSubstitutor interpolates ${script:...}.
import org.apache.commons.text.StringSubstitutor;
import javax.servlet.http.HttpServletRequest;

public class Cve202242889Text4shellTp {
    public String render(HttpServletRequest req) {
        String input = req.getParameter("q");                 // SOURCE
        return new StringSubstitutor().replace(input);         // SINK CWE-94 — ${script:js:...} executes
    }
}
