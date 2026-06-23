// Vector/Embedding Weakness (OWASP LLM08) — retrieval with no tenant filter. TP.
package com.demo.aisec;

import java.util.ArrayList;
import java.util.List;

public class Llm08NoRetrievalAcl {
    public static class Doc { public String tenant; public String text; }
    private final List<Doc> sharedIndex = new ArrayList<>();
    public List<String> retrieve(String query) {
        List<String> out = new ArrayList<>();
        for (Doc d : sharedIndex) out.add(d.text); // SINK (LLM08): no ACL filter
        return out;
    }
}
