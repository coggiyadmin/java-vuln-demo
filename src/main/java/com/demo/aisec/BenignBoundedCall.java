// TN — benign single bounded model call.
package com.demo.aisec;

public class BenignBoundedCall {
    public String answer(String q) { return Llm.chatSystem("", q); }
}
