package com.demo.config.hardcoded_secrets;

import java.sql.DriverManager;
import java.sql.Connection;
public class V10DbPasswordTp {
    public Connection connect() throws Exception {
        return DriverManager.getConnection("jdbc:postgresql://db/app", "app", "S3cr3tP@ss!"); // SINK CWE-798
    }
}
