package com.demo.flow.tier1.ssti;

import javax.servlet.http.*;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import java.io.StringWriter;
public class V03EncodeSafe {
    public void render(HttpServletRequest req, HttpServletResponse res) throws Exception {
        VelocityContext ctx = new VelocityContext();
        ctx.put("n", req.getParameter("n"));
        Velocity.evaluate(ctx, res.getWriter(), "v", "<p>$n</p>");
    }
}
