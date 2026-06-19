package com.demo;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-624 Executable Regular Expression Error. A user-supplied pattern is compiled
 * and drives a replacement, letting the attacker control match logic. NO finding = FN.
 */
public class ExecutableRegex {

    public String redact(HttpServletRequest request) {
        String pattern = request.getParameter("p");   // SOURCE — attacker-controlled regex
        String text = request.getParameter("t");
        return Pattern.compile(pattern).matcher(text).replaceAll("#");  // executable regex → CWE-624
    }
}
