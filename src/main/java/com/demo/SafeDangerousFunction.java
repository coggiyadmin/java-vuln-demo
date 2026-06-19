package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — DangerousFunction.java; a constrained numeric add replaces script evaluation.
 */
public class SafeDangerousFunction {

    public long calc(HttpServletRequest request) {
        long a = Long.parseLong(request.getParameter("a"));
        long b = Long.parseLong(request.getParameter("b"));
        return a + b;                             // no dynamic evaluation
    }
}
