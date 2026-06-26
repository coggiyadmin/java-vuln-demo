package com.demo.flow.tier1.xxe;
import javax.xml.parsers.*;
import javax.servlet.http.*;
import java.sql.*;
public class V08WrongContextTp {
    public void parse(HttpServletRequest req) throws Exception {
        String n = req.getParameter("n");
        DriverManager.getConnection("jdbc:sqlite::memory:")
          .createStatement().execute("SELECT * FROM u WHERE n='" + n + "'");
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(req.getInputStream());
    }
}
