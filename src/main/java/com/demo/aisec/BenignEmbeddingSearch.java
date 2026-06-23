// TN — benign similarity over a fixed single-owner list.
package com.demo.aisec;

public class BenignEmbeddingSearch {
    public String nearest(double[] vec) { return (vec.length > 0 && vec[0] >= 0.5) ? "greeting" : "farewell"; }
}
