package com.demo.flow.tier1.path_traversal;

import java.io.*;
import javax.servlet.http.*;
public class V01BaselineTp {
    public String read(HttpServletRequest req) throws Exception {
        String p = req.getParameter("p"); // SOURCE
        return new String(new FileInputStream("/data/" + p).readAllBytes()); // SINK
    }
}
