package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * Combination #9 — COMMENT / STRING-LITERAL × PATH TRAVERSAL (CWE-22). The sink appears
 * only in a comment and a string literal — it must NOT fire (0 findings = correct).
 */
public class CommentStringPathTrav {

    public int x(HttpServletRequest req) {
        String name = req.getParameter("name");
        // new FileInputStream("/srv/app/data/" + name)   <-- commented sink, must not fire
        String example = "new FileInputStream(BASE + name)"; // string literal, must not fire
        return example.length() + name.length();
    }
}
