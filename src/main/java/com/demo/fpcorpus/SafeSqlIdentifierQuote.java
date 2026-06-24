// FP-target (cognium-dev#163) — SQL *identifier* escaped via a quoting helper; the column is
// validated/escaped, value is bound. Must not be flagged sql_injection.
package com.demo.fpcorpus;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class SafeSqlIdentifierQuote {
    private static String quoteIdent(String id) {
        if (!id.matches("[A-Za-z_][A-Za-z0-9_]*")) throw new IllegalArgumentException("bad ident");
        return "\"" + id + "\"";
    }
    public ResultSet byColumn(Connection c, String column, String value) throws Exception {
        PreparedStatement ps = c.prepareStatement("SELECT * FROM items WHERE " + quoteIdent(column) + " = ?");
        ps.setString(1, value);
        return ps.executeQuery();
    }
}
