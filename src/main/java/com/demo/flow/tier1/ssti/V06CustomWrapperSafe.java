package com.demo.flow.tier1.ssti;
import org.apache.velocity.app.Velocity;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("{", "").replace("}", ""); }
    public void render(HttpServletRequest req) throws Exception {
        String n = companySanitize(req.getParameter("n"));
        Velocity.evaluate(null, req.getWriter(), "v", "<p>" + n + "</p>");
    }
}
