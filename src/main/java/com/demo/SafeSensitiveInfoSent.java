package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SAFE mirror — SensitiveInfoSent.java; only non-sensitive fields are projected into the DTO.
 */
public class SafeSensitiveInfoSent {

    public void me(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        response.getWriter().print("{\"id\":7,\"name\":\"ada\"}");  // secrets excluded
    }
}
