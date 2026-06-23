// TN — benign template fill; validated typed fields, no AI surface.
package com.demo.aisec;

public class BenignTemplateFill {
    public String render(String user, int amount) {
        if (amount < 0) throw new IllegalArgumentException("amount must be non-negative");
        return "Hi " + user + ", your balance changed by " + amount + " credits.";
    }
}
