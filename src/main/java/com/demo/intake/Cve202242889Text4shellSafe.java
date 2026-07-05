package com.demo.intake;
// SAFE — the fix is to not run user input through an interpolator at all; escape and concatenate.
import org.apache.commons.text.StringEscapeUtils;
import javax.servlet.http.HttpServletRequest;

public class Cve202242889Text4shellSafe {
    public String render(HttpServletRequest req) {
        String name = req.getParameter("q");
        return "Hello " + StringEscapeUtils.escapeHtml4(name); // no StringSubstitutor -> no ${script:...}
    }
}
