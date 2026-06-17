package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.owasp.encoder.Encode;

/**
 * SAFE mirror — XssProbe.java; OWASP Encode.forHtml before output.
 */
public class SafeXss {

    public void renderGreeting(HttpServletResponse response, String name) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<h1>Hello " + Encode.forHtml(name) + "</h1>");
    }
}
