package com.demo;

/** CWE-260 — Password in Configuration File. Real credentials hardcoded in a config class.
 * NO finding = FALSE NEGATIVE. (CWE-798 family.) */
public class DbConfig {
    public static final String DB_HOST = "db.internal";
    public static final String DB_USER = "app";
    public static final String DB_PASSWORD = "Pr0d-DB-pass!2024";   // hardcoded credential → CWE-260
    public static final String SMTP_PASSWORD = "smtp-s3cret-key";   // hardcoded credential → CWE-260
}
