package com.demo.variants.sqli;

import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
public class V01StringConcat {
    public void q(HttpServletRequest req, Connection conn) throws Exception {
        String id = req.getParameter("id");
        Statement st = conn.createStatement();
        st.executeQuery("SELECT * FROM u WHERE id=" + id); // SINK CWE-89
    }
}
