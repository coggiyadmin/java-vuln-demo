package com.demo.flow.tier1.format_string;

import java.util.Formatter;
import javax.servlet.http.*;
public class V01BaselineTp {
    public void greet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String fmt = req.getParameter("fmt"); // SOURCE
        new Formatter(res.getWriter()).format(fmt, "guest"); // SINK CWE-134
    }
}
