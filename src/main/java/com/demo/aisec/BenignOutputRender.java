// TN — benign output rendering; fixed app-authored result, no model output.
package com.demo.aisec;

public class BenignOutputRender {
    public String renderSummary(int count, double total) {
        return String.format("Processed %d items totalling %.2f.", count, total);
    }
}
