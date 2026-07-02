package com.demo.variants.path_traversal;

import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
public class V04SendfileLibrary {
    public byte[] nioRead(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        return Files.readAllBytes(Paths.get("/var/data", name)); // SINK CWE-22 nio Paths
    }
}
