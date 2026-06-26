package com.demo.flow.tier1.nosql;
import com.mongodb.client.*;
import org.bson.Document;
import javax.servlet.http.*;
public class V07HardeningSafe {
    public void login(HttpServletRequest req) {
        String user = req.getParameter("user");
        if (user == null || user.length() > 32) throw new SecurityException();
        MongoClients.create().getDatabase("app").getCollection("users")
          .find(new Document("user", user).append("active", true));
    }
}
