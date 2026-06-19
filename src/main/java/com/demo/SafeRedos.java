package com.demo;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — RedosProbe.java; fixed server-side pattern, user text only.
 */
public class SafeRedos {

    private static final Pattern ALLOWED = Pattern.compile("^[a-z0-9_]{1,32}$");

    public boolean match(HttpServletRequest request) {
        String text = request.getParameter("t");
        return ALLOWED.matcher(text).matches();
    }
}
