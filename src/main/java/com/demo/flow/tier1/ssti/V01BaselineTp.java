package com.demo.flow.tier1.ssti;

import javax.servlet.http.*;
import org.apache.velocity.app.Velocity;
import java.io.StringWriter;
public class V01BaselineTp {
    public void render(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String n = req.getParameter("n"); // SOURCE
        Velocity.evaluate(null, res.getWriter(), "v", "<p>" + n + "</p>"); // SINK CWE-1336
    }
}
