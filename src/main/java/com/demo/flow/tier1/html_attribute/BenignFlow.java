// Benign — static href.
package com.demo.flow.tier1.html_attribute;

import javax.servlet.http.HttpServletResponse;

public class BenignFlow {
    public void link(HttpServletResponse resp) throws Exception {
        resp.getWriter().write("<a href=\"/home\">home</a>");
    }
}
