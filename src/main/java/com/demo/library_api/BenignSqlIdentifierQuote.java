package com.demo.library_api;

/** TN — SQL identifier quoting should be credited (#163). */
public class BenignSqlIdentifierQuote {
    public static String quoteIdent(String col) {
        if (!col.matches("^[a-z_]+$")) throw new IllegalArgumentException("bad col");
        return """ + col + """;
    }
}
