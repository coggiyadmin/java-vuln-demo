package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combinations #6/#7/#8 — SANITIZER × NoSQL INJECTION (CWE-943). */
public class SanitizerCombosNoSql {

    private static String escapeHtml(String s) { return s.replace("<", "_"); }
    private static String sanitize(String s) { return s; }
    public void wrong(com.mongodb.client.MongoCollection<org.bson.Document> coll, HttpServletRequest req) {
        coll.find(new org.bson.Document("$where", "this.user == '" + escapeHtml(req.getParameter("user")) + "'")); // CWE-943
    }

    public void fake(com.mongodb.client.MongoCollection<org.bson.Document> coll, HttpServletRequest req) {
        coll.find(new org.bson.Document("$where", "this.user == '" + sanitize(req.getParameter("user")) + "'")); // CWE-943
    }

    public void wrapped(com.mongodb.client.MongoCollection<org.bson.Document> coll, HttpServletRequest req) {
        coll.find(new org.bson.Document("user", req.getParameter("user"))); // expect 0 — no $where
    }
}
