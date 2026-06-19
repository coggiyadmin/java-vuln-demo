package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-839 Numeric Range Comparison Without Minimum Check. The index is checked
 * against the upper bound only, so a negative offset is accepted. NO finding = FN.
 */
public class RangeMinCheck {

    private static final String[] RECORDS = {"a", "b", "c"};

    public String record(HttpServletRequest request) {
        int i = Integer.parseInt(request.getParameter("i"));   // SOURCE
        if (i < RECORDS.length) {                  // upper bound only — no `i >= 0` → CWE-839
            return RECORDS[i];
        }
        return "not found";
    }
}
