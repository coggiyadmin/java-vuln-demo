// FP-target (elarasu cognium-dev#156) — rendering a PRECOMPILED, app-owned template with a
// data model is not code injection; the template text is trusted, only data is bound.
package com.demo.libapi;

import java.util.Map;

public class SafeCompiledTemplateRender {
    public interface Template { String render(Map<String, Object> model); }
    public String email(Template compiled, String userName) {
        return compiled.render(Map.of("name", userName)); // data-bind only — NOT a sink
    }
}
