package com.demo.variants.nosql;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import javax.servlet.http.HttpServletRequest;
public class V04MongoWhereClause {
    public void mongoWhere(HttpServletRequest req) {
        String name = req.getParameter("name"); // SOURCE
        MongoClients.create().getDatabase("app").getCollection("u")
            .find(new Document("$where", "this.name == '" + name + "'")); // SINK CWE-943
    }
}
