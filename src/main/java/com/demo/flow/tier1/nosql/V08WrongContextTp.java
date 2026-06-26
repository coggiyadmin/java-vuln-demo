package com.demo.flow.tier1.nosql;
import com.mongodb.client.*;
import org.bson.Document;
import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;
public class V08WrongContextTp {
    public void login(HttpServletRequest req) {
        String user = StringEscapeUtils.escapeHtml4(req.getParameter("user"));
        MongoClients.create().getDatabase("app").getCollection("users")
          .find(new Document("user", user));
    }
}
