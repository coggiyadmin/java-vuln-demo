package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #9 — COMMENT / STRING × XSS (CWE-79). Expect 0. */
public class CommentStringXss {
    public String probe(HttpServletRequest req) {
        String q = req.getParameter("q");
        String example = "<p>" + q + "</p>";
        return String.valueOf(example.length());
    }
}
