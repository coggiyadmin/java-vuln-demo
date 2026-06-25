package com.demo;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #3 — LOOPTAINT × NOSQL (CWE-943).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class LoopTaintNosql {

    // 3a. ARRAY ELEMENT BUILT IN LOOP
    public void viaList(HttpServletRequest req) throws Exception {
        String[] in = req.getParameterValues("q");
        String[] items = new String[in.length];
        for (int i = 0; i < in.length; i++) { items[i] = in[i]; }
        String q = items[0];
        MongoClients.create("mongodb://localhost").getDatabase("app").getCollection("u").find(new Document("name", q)).first(); // CWE-943
    }

    // 3b. STRING ACCUMULATOR
    public void viaAccum(HttpServletRequest req) throws Exception {
        String q = "";
        for (String x : req.getParameterValues("q")) { q += x; }
        MongoClients.create("mongodb://localhost").getDatabase("app").getCollection("u").find(new Document("name", q)).first(); // CWE-943
    }

    // 3c. ITERATE-AND-SINK
    public void viaIter(HttpServletRequest req) throws Exception {
        for (String q : req.getParameterValues("q")) {
            MongoClients.create("mongodb://localhost").getDatabase("app").getCollection("u").find(new Document("name", q)).first(); // CWE-943 per iteration
        }
    }

}
