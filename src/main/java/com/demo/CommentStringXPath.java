package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #9 — COMMENT / STRING-LITERAL × xpath. Expect 0 findings. */
public class CommentStringXPath {

    public String probe(HttpServletRequest req) {
        String n = req.getParameter("name");
        String example = "//user[name='" + n + "']";
        return String.valueOf(example.length());
    }
}
