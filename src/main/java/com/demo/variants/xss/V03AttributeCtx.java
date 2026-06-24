package com.demo.variants.xss;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V03AttributeCtx {
    public void attr(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String u = req.getParameter("u");
        res.getWriter().print("<a href="" + u + "">x</a>"); // SINK CWE-79
    }
}
