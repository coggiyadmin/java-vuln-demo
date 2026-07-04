package com.demo.variants.ssti;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.VelocityContext;
import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.io.StringWriter;
public class V51VelocityMerge {
    public String merge(HttpServletRequest req) throws Exception {
        String tpl = req.getParameter("tpl"); // SOURCE
        StringWriter w = new StringWriter();
        Velocity.evaluate(new VelocityContext(), w, "tag", new StringReader(tpl)); // SINK CWE-94 Velocity
        return w.toString();
    }
}
