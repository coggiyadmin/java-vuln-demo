package com.demo.variants.sqli;

import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
public class V02OrderBy {
    public void order(javax.servlet.http.HttpServletRequest req, java.sql.Connection conn) throws Exception {
        String sort = req.getParameter("sort");
        conn.createStatement().executeQuery("SELECT * FROM u ORDER BY " + sort); // SINK CWE-89
    }
}
