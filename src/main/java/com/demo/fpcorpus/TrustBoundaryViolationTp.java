// TP (CWE-501 / cognium-dev#117) — untrusted request data stored into the session (a trusted
// store) without validation; later read as if trusted. 0% recall today (FN target).
package com.demo.fpcorpus;
import javax.servlet.http.HttpServletRequest;
public class TrustBoundaryViolationTp {
    public void save(HttpServletRequest req) {
        req.getSession().setAttribute("role", req.getParameter("role")); // SINK (CWE-501)
    }
}
