// Vector/Embedding FN (OWASP LLM08) — shared cache keyed only by query, not tenant. MISS.
package com.demo.aisec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Llm08FnCrossTenant {
    private final Map<String, List<String>> cache = new HashMap<>();
    public List<String> retrieve(String tenant, String query) {
        if (cache.containsKey(query)) return cache.get(query); // SINK (LLM08 FN): key omits tenant
        List<String> res = List.of(tenant + ":" + query);
        cache.put(query, res);
        return res;
    }
}
