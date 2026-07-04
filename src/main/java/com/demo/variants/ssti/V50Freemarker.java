package com.demo.variants.ssti;

import freemarker.template.Configuration;
import freemarker.template.Template;
import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.io.StringWriter;
public class V50Freemarker {
    public String render(HttpServletRequest req) throws Exception {
        String tpl = req.getParameter("tpl"); // SOURCE
        Template t = new Template("t", new StringReader(tpl), new Configuration(Configuration.VERSION_2_3_31));
        StringWriter w = new StringWriter();
        t.process(new java.util.HashMap<>(), w); // SINK CWE-94 Freemarker
        return w.toString();
    }
}
