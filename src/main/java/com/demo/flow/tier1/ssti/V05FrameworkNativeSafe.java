package com.demo.flow.tier1.ssti;
import org.apache.velocity.*;
import org.apache.velocity.app.Velocity;
import javax.servlet.http.*;
public class V05FrameworkNativeSafe {
    public void render(HttpServletRequest req) throws Exception {
        VelocityContext ctx = new VelocityContext();
        ctx.put("n", req.getParameter("n"));
        Velocity.evaluate(ctx, req.getWriter(), "v", "<p>$n</p>");
    }
}
