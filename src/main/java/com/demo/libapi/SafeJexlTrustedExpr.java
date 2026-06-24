// FP-target (elarasu cognium-dev#161) — JEXL evaluates a HARDCODED expression, not user
// input. The engine must not flag library eval surfaces when the expression is constant.
package com.demo.libapi;

import org.apache.commons.jexl3.*;

public class SafeJexlTrustedExpr {
    private static final JexlEngine JEXL = new JexlBuilder().create();
    public Object discount(double price) {
        JexlContext ctx = new MapContext();
        ctx.set("price", price);
        return JEXL.createExpression("price * 0.9").evaluate(ctx); // constant expr — NOT a sink
    }
}
