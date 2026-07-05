package com.demo.taint.attack_surface.test;
public class CmdiTest {
    public void testRun() throws Exception {
        String q = System.getenv("Q");
        Runtime.getRuntime().exec("grep " + q); // SINK — test file
    }
}
