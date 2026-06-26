package com.demo.flow.tier1.xss;

import java.io.*;
import javax.servlet.http.*;
public class V01BaselineTp {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String q = req.getParameter("q"); // SOURCE
        res.getWriter().print("<h1>" + q + "</h1>"); // SINK CWE-79
    }
}
