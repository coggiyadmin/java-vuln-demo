package com.demo.variants.format_string;

import java.util.Formatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V01UserFormat {
    public void greet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String fmt = req.getParameter("fmt");
        new Formatter(res.getWriter()).format(fmt, "guest"); // SINK CWE-134
    }
}
