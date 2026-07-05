package com.demo.taint.attack_surface.test;
import java.nio.file.*;
public class PathtravTest {
    public byte[] testRead() throws Exception {
        String q = System.getenv("Q");
        return Files.readAllBytes(Paths.get("/data/" + q)); // SINK — test file
    }
}
