package com.demo.variants.ssti;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
public class V02UserTemplate {
    public String render(HttpServletRequest req) throws Exception {
        String t = req.getParameter("t");
        Template tpl = new Template("n", t, new Configuration(Configuration.VERSION_2_3_31));
        StringWriter sw = new StringWriter();
        tpl.process(java.util.Map.of(), sw); // SINK CWE-1336
        return sw.toString();
    }
}
