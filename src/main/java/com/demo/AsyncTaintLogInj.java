package com.demo;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Combination #4 — ASYNCTAINT × LOGINJ (CWE-117).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class AsyncTaintLogInj {

    // 4. COMPLETABLEFUTURE — taint carried through async computation
    public void handle(HttpServletRequest req) {
        String raw = req.getParameter("user");
        java.util.concurrent.CompletableFuture<String> f =
            java.util.concurrent.CompletableFuture.supplyAsync(() -> raw); // taint into future
        String user = f.get();
        Logger.getLogger("app").warning("login user=" + user); // CWE-117
    }

}
