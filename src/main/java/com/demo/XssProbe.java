package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 * FN probe — CWE-79 reflected XSS (Java category probe).
 */
public class XssProbe {

    public void renderGreeting(HttpServletResponse response, String name) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<h1>Hello " + name + "</h1>");
    }
}
