package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — UnboundedAllocation.java; requested size clamped to a hard limit.
 */
public class SafeUnboundedAllocation {

    private static final int MAX_BYTES = 1 << 20;  // 1 MiB cap

    public int alloc(HttpServletRequest request) {
        int n = Integer.parseInt(request.getParameter("n"));
        if (n < 0 || n > MAX_BYTES) {              // bounded
            throw new IllegalArgumentException("too large");
        }
        byte[] buf = new byte[n];
        return buf.length;
    }
}
