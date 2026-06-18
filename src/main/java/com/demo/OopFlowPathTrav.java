package com.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #5 — OOP OBJECT FLOW × PATH TRAVERSAL (CWE-22). Taint is injected
 * via the constructor, stored in a field, exposed through a getter, and reaches a
 * file-open sink. Each is a REAL path traversal; NO finding = FALSE NEGATIVE.
 */
public class OopFlowPathTrav {

    private static final String BASE = "/srv/app/data/";
    private final String name;     // taint-carrying field

    public OopFlowPathTrav(HttpServletRequest req) {
        this.name = req.getParameter("name");   // constructor-injected taint
    }

    public String getName() {
        return this.name;          // getter exposes the tainted field
    }

    // 5a. field read directly in a sink method
    public InputStream readDirect() throws Exception {
        return new FileInputStream(BASE + this.name);   // path-traversal sink (CWE-22)
    }

    // 5b. field read via getter into a sink
    public InputStream readViaGetter() throws Exception {
        return new FileInputStream(BASE + getName());   // path-traversal sink (CWE-22)
    }
}
