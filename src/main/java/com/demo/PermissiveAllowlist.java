package com.demo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-183 Permissive List of Allowed Inputs. The host allow-check uses substring
 * containment, so `evil-trusted.com.attacker.net` passes. Real vuln; NO finding = FN.
 */
public class PermissiveAllowlist {

    public void fetch(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        String target = request.getParameter("url");   // SOURCE
        if (target.contains("trusted.com")) {           // overly-permissive substring → CWE-183
            response.sendRedirect(target);
        }
    }
}
