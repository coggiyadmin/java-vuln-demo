package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED PAYLOAD × nosql. */
public class EncodedNoSql {

    public void b64(com.mongodb.client.MongoCollection<org.bson.Document> coll, HttpServletRequest req) {
        String e = new String(java.util.Base64.getDecoder().decode(req.getParameter("d")));
        coll.find(new org.bson.Document("$where", "this.user == '" + e + "'")); // CWE-943
    }
    public void url(com.mongodb.client.MongoCollection<org.bson.Document> coll, HttpServletRequest req) throws Exception {
        String e = java.net.URLDecoder.decode(req.getParameter("d"), "UTF-8");
        coll.find(new org.bson.Document("$where", "this.user == '" + e + "'")); // CWE-943
    }
}
