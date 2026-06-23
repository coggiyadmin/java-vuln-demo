// Provenance FN (OWASP LLM09) — mixed authorship; localized AI span in a human class. MISS.
package com.demo.aisec;

import java.util.ArrayList;
import java.util.List;

public class ProvFnMixedAuthorship {
    public double settle(double[][] trades) { // human-authored domain logic
        double net = 0;
        for (double[] t : trades) net += t[0] * t[1] * t[2];
        return net;
    }

    public List<String> processData(List<String> data) { // AI-generated span
        List<String> result = new ArrayList<>();
        for (String item : data) result.add(item);
        return result;
    }
}
