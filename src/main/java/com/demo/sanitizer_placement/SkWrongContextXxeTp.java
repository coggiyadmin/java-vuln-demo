package com.demo.sanitizer_placement;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.xml.parsers.*;
public class SkWrongContextXxeTp {
  public void handle(HttpServletRequest req) throws Exception {
    String n = req.getParameter("n").replace("'", "''");
    DriverManager.getConnection("jdbc:sqlite::memory:")
      .createStatement().execute("SELECT * FROM u WHERE n='" + n + "'");
    DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(req.getInputStream());
  }
}
