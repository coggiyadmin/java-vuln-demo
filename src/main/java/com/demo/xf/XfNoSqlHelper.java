package com.demo.xf;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class XfNoSqlHelper {
    public static FindIterable<Document> run(MongoCollection<Document> coll, String expr) {
        return coll.find(new BasicDBObject("$where", "this.user == '" + expr + "'")); // SINK CWE-943
    }
}
