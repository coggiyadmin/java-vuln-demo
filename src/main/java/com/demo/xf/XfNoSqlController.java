package com.demo.xf;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import javax.servlet.http.HttpServletRequest;
import org.bson.Document;

public class XfNoSqlController {
    public FindIterable<Document> handle(HttpServletRequest req, MongoCollection<Document> coll) {
        String user = req.getParameter("user");   // SOURCE
        return XfNoSqlHelper.run(coll, user);      // cross-file call (CWE-943)
    }
}
