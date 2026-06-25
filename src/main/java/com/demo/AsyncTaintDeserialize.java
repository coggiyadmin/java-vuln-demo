package com.demo;

import java.io.*;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #4 — ASYNCTAINT × DESERIALIZE (CWE-502).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class AsyncTaintDeserialize {

    // 4. COMPLETABLEFUTURE — taint carried through async computation
    public void handle(HttpServletRequest req) throws Exception {
        String raw = req.getParameter("s");
        java.util.concurrent.CompletableFuture<String> f =
            java.util.concurrent.CompletableFuture.supplyAsync(() -> raw); // taint into future
        String s = f.get();
        new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(s))).readObject(); // CWE-502
    }

}
