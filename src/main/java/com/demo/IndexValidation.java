package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-1285 Improper Validation of Specified Index/Position/Offset.
 * User-supplied index accesses an array with no bounds check.
 */
public class IndexValidation {

    private static final int[] ACCOUNTS = {0, 1, 2};

    public int account(HttpServletRequest request) {
        int i = Integer.parseInt(request.getParameter("i"));  // SOURCE — unchecked index
        return ACCOUNTS[i];                                    // out-of-range / negative → CWE-1285
    }
}
