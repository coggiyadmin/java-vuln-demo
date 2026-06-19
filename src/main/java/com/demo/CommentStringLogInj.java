package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #9 — COMMENT / STRING-LITERAL × loginj. Expect 0 findings. */
public class CommentStringLogInj {

    public String probe(HttpServletRequest req) {
        String u = req.getParameter("user");
        String example = "log.info(u)";
        return String.valueOf(example.length() + u.length());
    }
}
