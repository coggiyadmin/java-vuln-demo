package com.demo.taint.propagation;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
public class PRP11_sqli {
    public void h(HttpServletRequest req, Connection c) throws Exception {
        String s = req.getParameter("q"); // SOURCE
        final String[] cap = { s };
        java.util.function.Supplier<String> f = () -> cap[0];
        String t = f.get(); // closure capture
        c.createStatement().executeQuery("SELECT * FROM u WHERE n='" + t + "'"); // SINK
    }
}
