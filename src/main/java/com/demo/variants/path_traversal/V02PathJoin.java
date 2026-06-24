package com.demo.variants.path_traversal;

import java.nio.file.Paths;
import java.nio.file.Files;
import javax.servlet.http.HttpServletRequest;
public class V02PathJoin {
    public byte[] join(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        return Files.readAllBytes(Paths.get("/var/data", name)); // SINK CWE-22
    }
}
