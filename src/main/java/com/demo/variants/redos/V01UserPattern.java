package com.demo.variants.redos;

import java.util.regex.*;
import javax.servlet.http.*;
public class V01UserPattern {
    public void match(HttpServletRequest req) throws Exception {
        String pattern = req.getParameter("p"); // SOURCE
        Pattern.compile(pattern).matcher(req.getParameter("t")).matches(); // SINK
    }
}
