package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SAFE mirror — SystemInfoExposure.java; returns only a static health status.
 */
public class SafeSystemInfoExposure {

    public void debug(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        response.getWriter().print("{\"status\":\"ok\"}");  // no system/env information disclosed
    }
}
