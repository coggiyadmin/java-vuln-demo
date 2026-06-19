package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #9 — COMMENT / STRING-LITERAL × xxe. Expect 0 findings. */
public class CommentStringXxe {

    public String probe(HttpServletRequest req) {
        String x = req.getParameter("xml");
        String example = "parseXml(x)";
        return String.valueOf(example.length() + x.length());
    }
}
