package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #9 — COMMENT / STRING-LITERAL × nosql. Expect 0 findings. */
public class CommentStringNoSql {

    public String probe(HttpServletRequest req) {
        String u = req.getParameter("user");
        String example = "$where: this.user == '" + u + "'";
        return String.valueOf(example.length());
    }
}
