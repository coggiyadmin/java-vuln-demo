package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — RangeMinCheck.java; both lower and upper bounds are checked.
 */
public class SafeRangeMinCheck {

    private static final String[] RECORDS = {"a", "b", "c"};

    public String record(HttpServletRequest request) {
        int i = Integer.parseInt(request.getParameter("i"));
        if (i >= 0 && i < RECORDS.length) {        // both bounds checked
            return RECORDS[i];
        }
        return "not found";
    }
}
