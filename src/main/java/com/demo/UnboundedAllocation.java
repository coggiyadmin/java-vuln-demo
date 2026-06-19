package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-770 Allocation of Resources Without Limits or Throttling.
 * Buffer allocated from a user-supplied size with no upper bound → memory-exhaustion DoS.
 */
public class UnboundedAllocation {

    public int alloc(HttpServletRequest request) {
        int n = Integer.parseInt(request.getParameter("n"));  // SOURCE — attacker-controlled size
        byte[] buf = new byte[n];                              // unbounded allocation → CWE-770
        return buf.length;
    }
}
