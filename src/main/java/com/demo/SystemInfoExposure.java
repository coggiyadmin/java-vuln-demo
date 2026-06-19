package com.demo;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FN probe — CWE-497 Exposure of Sensitive System Information.
 * A debug endpoint returns the full environment and platform details to the client.
 */
public class SystemInfoExposure {

    public void debug(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        Map<String, String> env = System.getenv();   // secrets, paths, versions
        // leaks environment to an unauthorized actor → CWE-497
        response.getWriter().print(env.toString() + System.getProperty("os.name"));
    }
}
