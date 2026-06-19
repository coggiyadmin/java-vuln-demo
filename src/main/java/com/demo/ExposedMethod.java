package com.demo;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-749 Exposed Dangerous Method or Function. A privileged maintenance routine is
 * exposed on an unauthenticated handler. Real vuln; NO finding = FN.
 */
public class ExposedMethod {

    public void maintenance(HttpServletRequest request) throws IOException {
        // privileged maintenance action exposed with no auth gate → CWE-749
        Runtime.getRuntime().exec("/opt/app/bin/cleanup.sh");
    }
}
