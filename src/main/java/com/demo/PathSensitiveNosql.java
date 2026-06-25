package com.demo;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #2 — PATHSENSITIVITY × NOSQL (CWE-943).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class PathSensitiveNosql {

    // 2a. NEGATED GUARD
    public void neg(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q");
        if (q.equals("safe")) { /* guard covers only literal */ } else { MongoClients.create("mongodb://localhost").getDatabase("app").getCollection("u").find(new Document("name", q)).first(); } // CWE-943
    }

    // 2b. ONE-BRANCH CONSTRAINT — else path leaves value unchecked
    public void oneBranch(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q");
        if (false) { q = "safe_literal"; } // dead branch
        MongoClients.create("mongodb://localhost").getDatabase("app").getCollection("u").find(new Document("name", q)).first(); // CWE-943
    }

    // 2c. EARLY-RETURN GUARD that does NOT cover the sink path
    public void early(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q");
        if (q == null || q.isEmpty()) { return; }
        MongoClients.create("mongodb://localhost").getDatabase("app").getCollection("u").find(new Document("name", q)).first(); // CWE-943
    }

}
