// Vector/Embedding Weakness (OWASP LLM08) — untrusted doc embedded unsanitized. TP.
package com.demo.aisec;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Llm08UnsanitizedVectorIngest {
    private final List<String> index = new ArrayList<>();
    public void ingest(String url) throws Exception {
        HttpResponse<String> r = HttpClient.newHttpClient().send(
            HttpRequest.newBuilder(URI.create(url)).build(), HttpResponse.BodyHandlers.ofString());
        index.add(r.body()); // SINK (LLM08): unsanitized into shared index
    }
}
