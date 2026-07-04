package com.demo.variants.format_string;

import java.text.MessageFormat;
import javax.servlet.http.HttpServletRequest;
public class V51Messageformat {
    public String fmt(HttpServletRequest req) {
        String pattern = req.getParameter("p"); // SOURCE
        return MessageFormat.format(pattern, "arg"); // SINK CWE-134 MessageFormat user pattern
    }
}
