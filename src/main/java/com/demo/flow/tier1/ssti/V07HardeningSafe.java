package com.demo.flow.tier1.ssti;
import org.apache.velocity.*;
import org.apache.velocity.app.Velocity;
import javax.servlet.http.*;
public class V07HardeningSafe {
    public void render(HttpServletRequest req) throws Exception {
        String n = req.getParameter("n");
        if (n.length() > 32) throw new SecurityException();
        VelocityContext ctx = new VelocityContext();
        ctx.put("n", n);
        Velocity.evaluate(ctx, req.getWriter(), "v", "<p>$n</p>");
    }
}
