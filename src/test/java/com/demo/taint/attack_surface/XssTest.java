package com.demo.taint.attack_surface.test;
public class XssTest {
    public String testRender() {
        String q = System.getenv("Q");
        return "<p>" + q + "</p>"; // SINK — test file
    }
}
