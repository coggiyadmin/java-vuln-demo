package com.demo;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-625 / CWE-1333 ReDoS (user-controlled regex pattern).
 * Cross-language mirror of python-vuln-demo/user_regex.py.
 */
public class RedosProbe {

    public boolean match(HttpServletRequest request) {
        String pattern = request.getParameter("p");
        String text = request.getParameter("t");
        return Pattern.compile(pattern).matcher(text).matches();
    }
}
