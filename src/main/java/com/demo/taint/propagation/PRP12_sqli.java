package com.demo.taint.propagation;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
public class PRP12_sqli {
    static String G;
    public void h(HttpServletRequest req, Connection c) throws Exception {
        String s = req.getParameter("q"); // SOURCE
        G = s;
        String t = G; // static field
        c.createStatement().executeQuery("SELECT * FROM u WHERE n='" + t + "'"); // SINK
    }
}
