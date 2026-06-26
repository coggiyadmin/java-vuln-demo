package com.demo.flow.tier1.xpath;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import javax.servlet.http.*;
import java.sql.*;
public class V08WrongContextTp {
    public void eval(HttpServletRequest req, XPath xp) throws Exception {
        String name = req.getParameter("name");
        DriverManager.getConnection("jdbc:sqlite::memory:")
          .createStatement().execute("SELECT * FROM u WHERE n='" + name + "'");
        xp.evaluate("//user[name='" + name + "']", new InputSource());
    }
}
