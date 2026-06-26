package com.demo.flow.tier1.path_traversal;
import java.io.*; import javax.servlet.http.*;
public class V02ValidateSafe {
    public String read(HttpServletRequest req) throws Exception {
        String p = req.getParameter("p");
        if (p.contains("..")) throw new SecurityException();
        return new String(new FileInputStream("/data/" + p).readAllBytes());
    }
}
