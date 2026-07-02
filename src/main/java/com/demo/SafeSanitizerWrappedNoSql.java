package com.demo;

import javax.servlet.http.HttpServletRequest;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/** c08 SAFE — allowlisted key × NoSQL (CWE-943). Expect clean. */
public class SafeSanitizerWrappedNoSql {
    private static String checkedKey(String k) {
        if (!k.matches("[a-zA-Z0-9_-]+")) throw new IllegalArgumentException(k);
        return k;
    }
    public void wrapped(HttpServletRequest req, MongoCollection<Document> coll) {
        String k = checkedKey(req.getParameter("k"));
        coll.find(new Document("user", k));
    }
}
