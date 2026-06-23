// SAFE mirror (OWASP LLM05) — constant parameterized query per allowed field.
package com.demo.aisec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SafeLlm05OutputToSql {
    public ResultSet search(Connection c, String field, String value) throws Exception {
        PreparedStatement ps;
        if ("name".equals(field)) ps = c.prepareStatement("SELECT * FROM items WHERE name = ?");
        else if ("sku".equals(field)) ps = c.prepareStatement("SELECT * FROM items WHERE sku = ?");
        else throw new IllegalArgumentException("field not allowed");
        ps.setString(1, value);
        return ps.executeQuery();
    }
}
