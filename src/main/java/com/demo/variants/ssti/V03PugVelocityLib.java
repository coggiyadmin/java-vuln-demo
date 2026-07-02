package com.demo.variants.ssti;

import org.apache.velocity.app.Velocity;
import javax.servlet.http.HttpServletRequest;
public class V03PugVelocityLib {
    public void velocity(HttpServletRequest req) {
        String name = req.getParameter("name");
        Velocity.evaluate(new java.io.StringWriter(), null, "t", "Hello " + name); // SINK CWE-94 velocity
    }
}
