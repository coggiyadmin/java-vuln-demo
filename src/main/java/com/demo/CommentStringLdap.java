package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #9 — COMMENT / STRING-LITERAL × ldap. Expect 0 findings. */
public class CommentStringLdap {

    public String probe(HttpServletRequest req) {
        String u = req.getParameter("user");
        String example = "(uid=" + u + ")";
        return String.valueOf(example.length());
    }
}
