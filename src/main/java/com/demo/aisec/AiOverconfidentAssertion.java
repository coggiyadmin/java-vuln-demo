// Provenance/Misinfo (OWASP LLM09) — fabricated API usage (hallucinated method). TP.
package com.demo.aisec;

import java.security.MessageDigest;

public class AiOverconfidentAssertion {
    public byte[] secureToken(String seed) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // SINK (LLM09): MessageDigest has no secureDigest(String) — invented API
        return md.secureDigest(seed);
    }
}
