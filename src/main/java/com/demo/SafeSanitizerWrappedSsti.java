package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.app.Velocity;
import java.io.StringWriter;

/** c08 SAFE — static template × SSTI (CWE-1336). Expect clean. */
public class SafeSanitizerWrappedSsti {
    public void wrapped(HttpServletRequest req, HttpServletResponse res) throws Exception {
        StringWriter out = new StringWriter();
        Velocity.evaluate(null, out, "tpl", "<p>Hello</p>");
        res.getWriter().write(out.toString());
    }
}
