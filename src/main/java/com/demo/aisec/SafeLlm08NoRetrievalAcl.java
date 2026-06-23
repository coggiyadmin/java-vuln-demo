// SAFE mirror (OWASP LLM08) — retrieval scoped to the caller's tenant first.
package com.demo.aisec;

import java.util.ArrayList;
import java.util.List;

public class SafeLlm08NoRetrievalAcl {
    public static class Doc { public String tenant; public String text; }
    private final List<Doc> index = new ArrayList<>();
    public List<String> retrieve(String tenant, String query) {
        List<String> out = new ArrayList<>();
        for (Doc d : index) if (d.tenant.equals(tenant)) out.add(d.text);
        return out;
    }
}
