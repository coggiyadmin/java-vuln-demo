package com.demo;

import javax.servlet.http.HttpServletRequest;

/** CWE-470 — Unsafe Reflection. User input selects the class to instantiate. NO finding = FN. */
public class UnsafeReflection {
    public Object make(HttpServletRequest req) throws Exception {
        String cls = req.getParameter("cls");   // SOURCE
        return Class.forName(cls).getDeclaredConstructor().newInstance();  // arbitrary class → CWE-470
    }
}
