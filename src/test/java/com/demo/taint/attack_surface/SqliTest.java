package com.demo.taint.attack_surface.test;
import java.sql.*;
public class SqliTest {
    public void testQuery(Connection c) throws Exception {
        String q = System.getenv("Q");
        c.createStatement().executeQuery("SELECT * FROM u WHERE n='" + q + "'"); // SINK — test file
    }
}
