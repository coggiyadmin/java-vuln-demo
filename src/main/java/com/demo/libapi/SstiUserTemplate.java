// TP (CWE-1336 / SSTI) — genuine server-side template injection: user controls the template
// source, not just the data model.
package com.demo.libapi;

public class SstiUserTemplate {
    public interface Engine { String parseAndRender(String templateSource); }
    public String run(Engine engine, String userTemplate) {
        return engine.parseAndRender(userTemplate); // SINK (SSTI)
    }
}
