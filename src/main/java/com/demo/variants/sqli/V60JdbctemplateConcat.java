package com.demo.variants.sqli;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.servlet.http.HttpServletRequest;
public class V60JdbctemplateConcat {
    public void query(HttpServletRequest req, JdbcTemplate jdbc) {
        String name = req.getParameter("name"); // SOURCE
        jdbc.queryForList("SELECT * FROM users WHERE name = '" + name + "'"); // SINK CWE-89 JdbcTemplate concat
    }
}
