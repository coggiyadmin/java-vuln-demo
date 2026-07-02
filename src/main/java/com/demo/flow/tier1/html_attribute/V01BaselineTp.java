// TP (CWE-79 / cognium-dev#153) — user input in HTML attribute context without encoding.
package com.demo.flow.tier1.html_attribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class V01BaselineTp {
    public void link(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getParameter("url");
        resp.getWriter().write("<a href=\"" + url + "\">click</a>"); // SINK (attribute context)
    }
}
