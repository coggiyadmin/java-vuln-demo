package com.demo;

import javax.naming.directory.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;
import javax.naming.InitialContext;

/**
 * Combination #4 — ASYNCTAINT × LDAP (CWE-90).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class AsyncTaintLdap {

    // 4. COMPLETABLEFUTURE — taint carried through async computation
    public void handle(HttpServletRequest req) throws Exception {
        String raw = req.getParameter("user");
        java.util.concurrent.CompletableFuture<String> f =
            java.util.concurrent.CompletableFuture.supplyAsync(() -> raw); // taint into future
        String user = f.get();
        new InitialContext().search("dc=ex", "(uid=" + user + ")", new SearchControls()); // CWE-90
    }

}
