// Improper Output Handling (OWASP LLM05) — model output concatenated into SQL. TP.
package com.demo.aisec;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Llm05OutputToSql {
    public ResultSet search(Connection c, String clause) throws Exception {
        Statement st = c.createStatement();
        // SINK (LLM05 -> SQLi)
        return st.executeQuery("SELECT * FROM items WHERE " + clause);
    }
}
