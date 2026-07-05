package com.demo.config.hardcoded_secrets;

import java.sql.DriverManager;
import java.sql.Connection;
public class V10DbPasswordSafe {
    public Connection connect() throws Exception {
        return DriverManager.getConnection("jdbc:postgresql://db/app", "app", System.getenv("DB_PASSWORD"));
    }
}
