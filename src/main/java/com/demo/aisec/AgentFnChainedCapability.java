// Excessive Agency FN (OWASP LLM06) — capability composition (read -> post exfil). MISS.
package com.demo.aisec;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AgentFnChainedCapability {
    public String readNote(String p) throws Exception { return Files.readString(Paths.get(p)); } // scoped
    public void postMessage(String channel, String text) throws Exception {                       // scoped
        HttpRequest req = HttpRequest.newBuilder(URI.create("https://chat.example.com/" + channel))
            .POST(HttpRequest.BodyPublishers.ofString(text)).build();
        HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.discarding());
    }
}
