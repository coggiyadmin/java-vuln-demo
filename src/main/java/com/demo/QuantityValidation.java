package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-1284 Improper Validation of Specified Quantity in Input. A user-supplied
 * order quantity is used unchecked (negative / huge) in pricing and allocation. NO finding = FN.
 */
public class QuantityValidation {

    private static final int UNIT_PRICE = 1000;

    public long order(HttpServletRequest request) {
        int qty = Integer.parseInt(request.getParameter("qty"));  // SOURCE — unvalidated quantity
        int[] slots = new int[qty];                               // negative/huge used unchecked → CWE-1284
        return (long) UNIT_PRICE * qty + slots.length;            // negative qty → negative total
    }
}
