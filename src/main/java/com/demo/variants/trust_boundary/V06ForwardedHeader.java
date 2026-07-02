package com.demo.variants.trust_boundary;

import javax.servlet.http.*;
public class V06ForwardedHeader {
    public void admin(HttpServletRequest req) {
        String role = req.getHeader("X-Forwarded-Role");
        req.getSession().setAttribute("role", role); // SINK CWE-501 forwarded header trusted
    }
}
