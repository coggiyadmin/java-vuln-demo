package com.demo;

import java.io.FileInputStream;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #4 — ASYNC taint × PATH TRAVERSAL (CWE-22).
 */
public class AsyncTaintPathTrav {

    private static final String BASE = "/srv/app/data/";

    public void handle(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> name);
        new FileInputStream(BASE + f.get()); // CWE-22
    }
}
