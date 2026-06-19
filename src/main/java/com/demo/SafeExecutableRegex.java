package com.demo;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — ExecutableRegex.java; a fixed server-side pattern redacts user text only.
 */
public class SafeExecutableRegex {

    private static final Pattern DIGITS = Pattern.compile("\\d");

    public String redact(HttpServletRequest request) {
        String text = request.getParameter("t");
        return DIGITS.matcher(text == null ? "" : text).replaceAll("#");  // static pattern
    }
}
