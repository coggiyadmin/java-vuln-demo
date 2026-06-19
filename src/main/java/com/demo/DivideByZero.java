package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-369 Divide By Zero. A user-supplied divisor can be 0.
 */
public class DivideByZero {

    public int average(HttpServletRequest request) {
        int total = 1000;
        int n = Integer.parseInt(request.getParameter("n"));  // SOURCE — divisor, can be 0
        return total / n;                                     // divide-by-zero → CWE-369
    }
}
