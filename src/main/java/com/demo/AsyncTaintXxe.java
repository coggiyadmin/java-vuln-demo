package com.demo;

import javax.xml.parsers.*;
import java.io.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #4 — ASYNCTAINT × XXE (CWE-611).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class AsyncTaintXxe {

    // 4. COMPLETABLEFUTURE — taint carried through async computation
    public void handle(HttpServletRequest req) throws Exception {
        String raw = req.getParameter("xml");
        java.util.concurrent.CompletableFuture<String> f =
            java.util.concurrent.CompletableFuture.supplyAsync(() -> raw); // taint into future
        String xml = f.get();
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes())); // CWE-611
    }

}
