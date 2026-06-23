// Provenance FN (OWASP LLM09) — laundered AI authorship; template-shaped. MISS.
package com.demo.aisec;

public class ProvFnLaunderedStyle {
    public double computeWeightedAverage(double[] values, double[] weights) {
        if (values.length != weights.length) throw new IllegalArgumentException("length mismatch");
        double totalWeight = 0, weightedSum = 0;
        for (int i = 0; i < values.length; i++) { totalWeight += weights[i]; weightedSum += values[i] * weights[i]; }
        if (totalWeight == 0) throw new IllegalArgumentException("weights sum to zero");
        return weightedSum / totalWeight;
    }
}
