package com.demo;

import java.util.UUID;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SAFE mirror — SensitiveInfoDebug.java; the debug branch returns only a correlation id.
 */
public class SafeSensitiveInfoDebug {

    private static final Logger log = Logger.getLogger("app");

    public void op(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        try {
            throw new RuntimeException("boom");
        } catch (RuntimeException e) {
            String ref = UUID.randomUUID().toString();
            log.severe("op failed ref=" + ref);   // detail stays server-side
            response.getWriter().print("error ref=" + ref);
        }
    }
}
