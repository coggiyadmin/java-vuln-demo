package com.demo.flow.tier1.sqli;

import java.sql.*;
import javax.servlet.http.HttpServletRequest;
public class V01BaselineTp {
    public void run(HttpServletRequest req, Connection db) throws Exception {
        String name = req.getParameter("name"); // SOURCE
        db.createStatement().executeQuery("SELECT * FROM users WHERE name='" + name + "'"); // SINK
    }
}
