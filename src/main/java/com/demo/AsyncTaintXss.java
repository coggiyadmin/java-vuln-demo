package com.demo;

import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Combination #4 — ASYNC × XSS (CWE-79). NO finding = FALSE NEGATIVE. */
public class AsyncTaintXss {
    public void handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String q = req.getParameter("q");
        CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> q);
        String html = "<p>" + f.get() + "</p>"; // CWE-79
        res.getWriter().write(html);
    }
}
