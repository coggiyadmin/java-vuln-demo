package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #11 — FAN-OUT × nosql. */
public class FanoutNoSql {

    public void fanout(com.mongodb.client.MongoCollection<org.bson.Document> coll, HttpServletRequest req) {
        String u = req.getParameter("u");
        coll.find(new org.bson.Document("$where", "this.a == '" + u + "'")); // CWE-943
        coll.find(new org.bson.Document("$where", "this.b == '" + u + "'")); // CWE-943
        coll.find(new org.bson.Document("$where", "this.c == '" + u + "'")); // CWE-943
    }
}
