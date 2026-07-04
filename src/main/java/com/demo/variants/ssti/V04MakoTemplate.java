package com.demo.variants.ssti;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringReader;
import javax.servlet.http.HttpServletRequest;
public class V04MakoTemplate {
    public void mako(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q");
        new Template("t", new StringReader(q), new Configuration()).process(null, null); // SINK CWE-94
    }
}
