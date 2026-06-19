package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #9 — COMMENT / STRING-LITERAL × deserialize. Expect 0 findings. */
public class CommentStringDeserialize {

    public String probe(HttpServletRequest req) {
        String s = req.getParameter("s");
        String example = "unserialize(s)";
        return String.valueOf(example.length() + s.length());
    }
}
