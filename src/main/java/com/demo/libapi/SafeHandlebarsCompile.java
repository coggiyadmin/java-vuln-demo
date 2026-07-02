// FP-target (upstream cognium-dev#156) — Handlebars.compile on a static template;
// user data is bound at render only. Real handlebars type for faithful #156 reproduction.
package com.demo.libapi;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import java.io.IOException;
import java.util.Map;

public class SafeHandlebarsCompile {
    private static final Handlebars HB = new Handlebars();

    public String render(String userName) throws IOException {
        Template tpl = HB.compileInline("<p>{{name}}</p>");
        return tpl.apply(Map.of("name", userName));
    }
}
