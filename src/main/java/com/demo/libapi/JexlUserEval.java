// TP (CWE-94) — genuine code injection: user-controlled JEXL expression evaluated.
package com.demo.libapi;

import org.apache.commons.jexl3.*;

public class JexlUserEval {
    private static final JexlEngine JEXL = new JexlBuilder().create();
    public Object run(String userExpr) {
        return JEXL.createExpression(userExpr).evaluate(new MapContext()); // SINK (CWE-94)
    }
}
