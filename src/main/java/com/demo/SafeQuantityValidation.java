package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — QuantityValidation.java; the quantity is validated against a sane range.
 */
public class SafeQuantityValidation {

    private static final int UNIT_PRICE = 1000;
    private static final int MAX_QTY = 100;

    public long order(HttpServletRequest request) {
        int qty = Integer.parseInt(request.getParameter("qty"));
        if (qty < 1 || qty > MAX_QTY) {           // validated range
            throw new IllegalArgumentException("invalid quantity");
        }
        return (long) UNIT_PRICE * qty;
    }
}
