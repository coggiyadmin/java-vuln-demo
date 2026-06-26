package com.demo.intake;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.encoder.Encode;

/** Safe mirror — OWASP Encoder before HTML output. */
public class ServletReflectedXssSafe {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String msg = req.getParameter("msg");
        PrintWriter out = res.getWriter();
        out.print("<p class=\"notice\">" + Encode.forHtml(msg) + "</p>");
    }
}
