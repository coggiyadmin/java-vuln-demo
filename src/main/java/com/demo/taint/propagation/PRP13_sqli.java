package com.demo.taint.propagation;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
public class PRP13_sqli {
    public void h(HttpServletRequest req, Connection c) throws Exception {
        String s = req.getParameter("q"); // SOURCE
        java.util.Map<String,String> m = new java.util.HashMap<>(); m.put("v", s);
        String t = m.get("v"); // map round-trip
        c.createStatement().executeQuery("SELECT * FROM u WHERE n='" + t + "'"); // SINK
    }
}
