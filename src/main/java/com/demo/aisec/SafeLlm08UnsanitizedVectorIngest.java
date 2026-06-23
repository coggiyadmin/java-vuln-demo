// SAFE mirror (OWASP LLM08) — sanitized, size-bounded, namespaced per tenant.
package com.demo.aisec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SafeLlm08UnsanitizedVectorIngest {
    private final Map<String, List<String>> index = new HashMap<>();
    public void ingest(String tenant, String text) {
        String clean = text.replace("\u0000", "");
        if (clean.length() > 20000) clean = clean.substring(0, 20000);
        index.computeIfAbsent(tenant, k -> new ArrayList<>()).add(clean);
    }
}
