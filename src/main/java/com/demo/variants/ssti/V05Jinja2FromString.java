package com.demo.variants.ssti;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.servlet.http.HttpServletRequest;
public class V05Jinja2FromString {
    public String thymeleaf(HttpServletRequest req) {
        String q = req.getParameter("q"); // SOURCE
        return new TemplateEngine().process(q, new Context()); // SINK CWE-94
    }
}
