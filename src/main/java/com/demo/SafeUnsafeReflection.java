package com.demo;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — UnsafeReflection; class name checked against a fixed allowlist. Expect 0. */
public class SafeUnsafeReflection {
    private static final Set<String> ALLOWED = Set.of("com.demo.CsvExport", "com.demo.JsonExport");

    public Object make(HttpServletRequest req) throws Exception {
        String cls = req.getParameter("cls");
        if (!ALLOWED.contains(cls)) {
            throw new SecurityException("denied");
        }
        return Class.forName(cls).getDeclaredConstructor().newInstance();
    }
}
