package com.demo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import javax.servlet.http.HttpServletRequest;
import org.bson.Document;

/** SAFE mirror — OopFlowNoSql; value-bound equality match, no $where. Expect 0 findings. */
public class SafeOopFlowNoSql {

    private final String expr;

    public SafeOopFlowNoSql(HttpServletRequest req) {
        this.expr = req.getParameter("user");
    }

    public FindIterable<Document> findDirect(MongoCollection<Document> coll) {
        return coll.find(new Document("user", this.expr));   // value-bound equality
    }
}
