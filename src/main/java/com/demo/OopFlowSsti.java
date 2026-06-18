package com.demo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Combination #5 — OOP OBJECT FLOW × SSTI / expression injection (CWE-1336/917).
 * Constructor-injected taint parsed as a SpEL expression. NO finding = FALSE NEGATIVE.
 */
public class OopFlowSsti {

    private final String name;

    public OopFlowSsti(HttpServletRequest req) {
        this.name = req.getParameter("name");
    }

    public String getName() {
        return this.name;
    }

    public Object renderDirect() {
        ExpressionParser p = new SpelExpressionParser();
        Expression e = p.parseExpression(this.name);   // SpEL injection sink (CWE-1336/917)
        return e.getValue();
    }

    public Object renderViaGetter() {
        ExpressionParser p = new SpelExpressionParser();
        return p.parseExpression(getName()).getValue();   // SpEL injection sink (CWE-1336/917)
    }
}
