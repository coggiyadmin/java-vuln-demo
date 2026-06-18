package com.demo.xf;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class XfSstiHelper {
    public static Object run(String name) {
        ExpressionParser p = new SpelExpressionParser();
        return p.parseExpression(name).getValue(); // SINK CWE-1336/917
    }
}
