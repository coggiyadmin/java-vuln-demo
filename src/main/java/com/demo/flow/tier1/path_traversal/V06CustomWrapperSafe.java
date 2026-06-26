package com.demo.flow.tier1.path_traversal;
import java.io.*; import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String p) { return p.replace("..", ""); }
    public String read(HttpServletRequest req) throws Exception {
        String p = companySanitize(req.getParameter("p"));
        return new String(new FileInputStream("/data/" + p).readAllBytes());
    }
}
