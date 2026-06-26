package com.demo.intake;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** TP — reflected param in HTML response (CWE-79 intake pattern). CVE-2022-42948 class. */
public class ServletReflectedXssTp {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String msg = req.getParameter("msg");
        PrintWriter out = res.getWriter();
        out.print("<p class=\"notice\">" + msg + "</p>"); // SINK CWE-79
    }
}
