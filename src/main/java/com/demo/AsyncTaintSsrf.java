package com.demo;

import java.net.URL;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #4 — ASYNC taint × SSRF (CWE-918). Taint carried through a
 * CompletableFuture, then fetched. NO finding = FALSE NEGATIVE.
 */
public class AsyncTaintSsrf {

    public void handle(HttpServletRequest req) throws Exception {
        String url = req.getParameter("url");
        CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> url); // taint into future
        String v = f.get();
        new URL(v).openStream();   // CWE-918
    }
}
