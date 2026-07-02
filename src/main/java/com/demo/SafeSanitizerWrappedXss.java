package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

/** c08 SAFE — HTML escape wrapper × XSS (CWE-79). Expect clean. */
public class SafeSanitizerWrappedXss {
    public void wrapped(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String q = req.getParameter("q");
        res.getWriter().write(StringEscapeUtils.escapeHtml4(q));
    }
}
