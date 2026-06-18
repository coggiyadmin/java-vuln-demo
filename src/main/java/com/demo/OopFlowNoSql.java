package com.demo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import javax.servlet.http.HttpServletRequest;
import org.bson.Document;

/**
 * Combination #5 — OOP OBJECT FLOW × NoSQL INJECTION (CWE-943). Constructor-injected
 * taint stored in a field, used in a Mongo $where clause. NO finding = FALSE NEGATIVE.
 */
public class OopFlowNoSql {

    private final String expr;

    public OopFlowNoSql(HttpServletRequest req) {
        this.expr = req.getParameter("user");
    }

    public String getExpr() {
        return this.expr;
    }

    public FindIterable<Document> findDirect(MongoCollection<Document> coll) {
        return coll.find(new BasicDBObject("$where", "this.user == '" + this.expr + "'"));   // CWE-943
    }

    public FindIterable<Document> findViaGetter(MongoCollection<Document> coll) {
        return coll.find(new BasicDBObject("$where", "this.user == '" + getExpr() + "'"));   // CWE-943
    }
}
