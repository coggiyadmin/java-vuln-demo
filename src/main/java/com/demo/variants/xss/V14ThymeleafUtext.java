package com.demo.variants.xss;

import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;
import javax.servlet.http.HttpServletRequest;
public class V14ThymeleafUtext {
    public String utext(HttpServletRequest req) {
        String q = req.getParameter("q"); // SOURCE
        Context ctx = new Context();
        ctx.setVariable("q", q);
        return new TemplateEngine().process("<div th:utext="${q}"></div>", ctx); // SINK CWE-79 th:utext
    }
}
