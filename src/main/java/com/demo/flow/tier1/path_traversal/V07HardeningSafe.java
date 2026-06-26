package com.demo.flow.tier1.path_traversal;

import java.io.*; import java.nio.file.*;
import javax.servlet.http.*;
public class V07HardeningSafe {
    public String read(HttpServletRequest req) throws Exception {
        Path root = Path.of("/data");
        Path full = root.resolve(req.getParameter("p")).normalize();
        if (!full.startsWith(root)) throw new SecurityException();
        return Files.readString(full);
    }
}
