package com.demo;

import javax.servlet.http.HttpServletRequest;

/** CWE-807 — Reliance on Untrusted Inputs in a Security Decision. A client-supplied header
 * is trusted to grant admin access. (Engine gap.) FN probe. */
public class UntrustedSecurityDecision {
    public String admin(HttpServletRequest req) {
        if ("true".equals(req.getHeader("X-Is-Admin"))) {   // trusts client header → CWE-807
            return "admin panel";
        }
        return "denied";
    }
}
