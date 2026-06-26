package com.demo.intake;

import javax.servlet.http.HttpServletRequest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/** TP — user SpEL evaluated server-side (CWE-94 intake pattern). CVE-2022-22947 class. */
public class SpelCloudFnTp {
    public Object eval(HttpServletRequest req) {
        String expr = req.getParameter("expr");
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expr); // SINK CWE-94
        return expression.getValue();
    }
}
