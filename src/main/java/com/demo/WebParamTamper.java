package com.demo;

import javax.servlet.http.HttpServletRequest;

/** CWE-472 — External Control of Assumed-Immutable Web Parameter. Server trusts a
 * client-supplied 'price' for a financial decision. (Engine gap.) FN probe. */
public class WebParamTamper {
    public double checkout(HttpServletRequest req) {
        String price = req.getParameter("price");   // SOURCE — client-controlled "hidden" field
        int qty = Integer.parseInt(req.getParameter("qty"));
        return Double.parseDouble(price) * qty;      // trusts client-set price → CWE-472
    }
}
