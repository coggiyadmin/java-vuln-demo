package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — IndexValidation.java; the index is range-checked before use.
 */
public class SafeIndexValidation {

    private static final int[] ACCOUNTS = {0, 1, 2};

    public int account(HttpServletRequest request) {
        int i = Integer.parseInt(request.getParameter("i"));
        if (i < 0 || i >= ACCOUNTS.length) {       // bounds-checked
            throw new IllegalArgumentException("not found");
        }
        return ACCOUNTS[i];
    }
}
