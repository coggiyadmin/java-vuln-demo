package com.demo.variants.xss;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** XSS variant: reflected HTML body. */
public class V01ReflectedBody {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String q = req.getParameter("q"); // SOURCE
        PrintWriter out = res.getWriter();
        out.print("<h1>" + q + "</h1>"); // SINK CWE-79
    }
}
