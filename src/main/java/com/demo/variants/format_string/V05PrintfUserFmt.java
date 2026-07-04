package com.demo.variants.format_string;

import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
public class V05PrintfUserFmt {
    public void printf(HttpServletRequest req) {
        String fmt = req.getParameter("fmt"); // SOURCE
        new PrintStream(System.out).printf(fmt, "arg"); // SINK CWE-134
    }
}
