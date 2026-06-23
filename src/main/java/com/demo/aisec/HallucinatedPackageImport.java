// Provenance/Misinfo (OWASP LLM09) — hallucinated dependency (slopsquatting surface).
package com.demo.aisec;

import com.example.hallucinated.HttpRetry; // SINK (LLM09): fabricated package

public class HallucinatedPackageImport {
    public String fetchUrl(String url) { return HttpRetry.get(url); }
}
