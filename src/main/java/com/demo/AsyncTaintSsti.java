package com.demo;

import freemarker.template.*;
import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;

/**
 * Combination #4 — ASYNCTAINT × SSTI (CWE-1336).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class AsyncTaintSsti {

    // 4. COMPLETABLEFUTURE — taint carried through async computation
    public void handle(HttpServletRequest req) throws Exception {
        String raw = req.getParameter("t");
        java.util.concurrent.CompletableFuture<String> f =
            java.util.concurrent.CompletableFuture.supplyAsync(() -> raw); // taint into future
        String t = f.get();
        new Template("t", t, new Configuration(Configuration.VERSION_2_3_31)).process(null, new StringWriter()); // CWE-1336
    }

}
