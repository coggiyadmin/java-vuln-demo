package com.demo.variants.trust_boundary;

import javax.servlet.http.HttpServletRequest;
public class V01SessionStore {
    public void save(HttpServletRequest req) {
        String role = req.getParameter("role"); // SOURCE
        req.getSession().setAttribute("role", role); // SINK CWE-501
    }
}
