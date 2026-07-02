// Safe mirror (cognium-dev#153) — attribute-encoded href.
package com.demo.flow.tier1.html_attribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

public class V01BaselineSafe {
    public void link(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = StringEscapeUtils.escapeHtml4(req.getParameter("url"));
        resp.getWriter().write("<a href=\"" + url + "\">click</a>");
    }
}
