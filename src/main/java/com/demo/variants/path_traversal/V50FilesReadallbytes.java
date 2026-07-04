package com.demo.variants.path_traversal;

import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
public class V50FilesReadallbytes {
    public byte[] read(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name"); // SOURCE
        return Files.readAllBytes(Paths.get("/var/data/" + name)); // SINK CWE-22 Files.readAllBytes
    }
}
