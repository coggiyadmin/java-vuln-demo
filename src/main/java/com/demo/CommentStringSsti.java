package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #9 — COMMENT / STRING-LITERAL × ssti. Expect 0 findings. */
public class CommentStringSsti {

    public String probe(HttpServletRequest req) {
        String n = req.getParameter("name");
        String example = "{{ " + n + " }}";
        return String.valueOf(example.length());
    }
}
