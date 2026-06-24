package com.demo.variants.ssti;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V01TemplateConcat {
    public void render(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String n = req.getParameter("n");
        org.apache.velocity.app.Velocity.evaluate(null, res.getWriter(), "v", "<p>" + n + "</p>"); // SINK CWE-1336
    }
}
