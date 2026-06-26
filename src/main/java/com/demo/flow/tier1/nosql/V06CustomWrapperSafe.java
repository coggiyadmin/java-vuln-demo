package com.demo.flow.tier1.nosql;
import com.mongodb.client.*;
import org.bson.Document;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("$", ""); }
    public void login(HttpServletRequest req) {
        String user = companySanitize(req.getParameter("user"));
        MongoClients.create().getDatabase("app").getCollection("users")
          .find(new Document("user", user));
    }
}
