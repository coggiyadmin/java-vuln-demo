package com.demo.flow.tier1.nosql;
import com.mongodb.client.*;
import org.bson.Document;
import javax.servlet.http.*;
public class V05FrameworkNativeSafe {
    public void login(HttpServletRequest req) {
        String user = req.getParameter("user");
        if (user == null || !user.matches("[A-Za-z0-9]+")) throw new SecurityException();
        MongoClients.create().getDatabase("app").getCollection("users")
          .find(new Document("user", user).append("active", true));
    }
}
