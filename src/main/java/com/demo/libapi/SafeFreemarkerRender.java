// FP-target (upstream cognium-dev#156) — Freemarker on a static template; user data at process only.
package com.demo.libapi;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

public class SafeFreemarkerRender {
    private static final Configuration CFG = new Configuration(Configuration.VERSION_2_3_32);

    public String render(String userName) throws Exception {
        Template tpl = new Template("greet", new StringReader("<p>${name}</p>"), CFG);
        StringWriter out = new StringWriter();
        tpl.process(Map.of("name", userName), out);
        return out.toString();
    }
}
