package com.demo;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #4 — ASYNCTAINT × NOSQL (CWE-943).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class AsyncTaintNosql {

    // 4. COMPLETABLEFUTURE — taint carried through async computation
    public void handle(HttpServletRequest req) throws Exception {
        String raw = req.getParameter("q");
        java.util.concurrent.CompletableFuture<String> f =
            java.util.concurrent.CompletableFuture.supplyAsync(() -> raw); // taint into future
        String q = f.get();
        MongoClients.create("mongodb://localhost").getDatabase("app").getCollection("u").find(new Document("name", q)).first(); // CWE-943
    }

}
