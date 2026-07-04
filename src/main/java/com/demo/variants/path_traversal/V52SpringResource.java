package com.demo.variants.path_traversal;

import org.springframework.core.io.FileSystemResource;
import javax.servlet.http.HttpServletRequest;
public class V52SpringResource {
    public java.io.InputStream load(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name"); // SOURCE
        return new FileSystemResource("/var/data/" + name).getInputStream(); // SINK CWE-22 Spring Resource
    }
}
