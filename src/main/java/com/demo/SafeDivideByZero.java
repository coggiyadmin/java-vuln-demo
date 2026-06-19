package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — DivideByZero.java; the divisor is checked for zero.
 */
public class SafeDivideByZero {

    public int average(HttpServletRequest request) {
        int total = 1000;
        int n = Integer.parseInt(request.getParameter("n"));
        if (n == 0) {                              // guarded
            throw new IllegalArgumentException("n must be non-zero");
        }
        return total / n;
    }
}
