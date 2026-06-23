// Excessive Agency FN (OWASP LLM06) — confused deputy: model-chosen URL fetched with an
// ambient privileged token, no host allowlist (SSRF via tool). Expected: trust layer MISS.
package com.demo.aisec;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AgentFnConfusedDeputy {
    public String fetchTool(String url) throws Exception {
        HttpRequest req = HttpRequest.newBuilder(URI.create(url)) // SINK (LLM06 confused-deputy)
            .header("Authorization", "Bearer " + System.getenv("SERVICE_TOKEN")).build();
        return HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString()).body();
    }
}
