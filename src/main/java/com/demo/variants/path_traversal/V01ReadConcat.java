package com.demo.variants.path_traversal;

import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V01ReadConcat {
    public void read(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String name = req.getParameter("name");
        var in = new FileInputStream("/var/data/" + name); // SINK CWE-22
        in.transferTo(res.getOutputStream());
    }
}
