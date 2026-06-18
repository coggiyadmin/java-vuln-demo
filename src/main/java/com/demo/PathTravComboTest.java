package com.demo;

import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #10 — TEST-FILE handling × PATH TRAVERSAL (CWE-22). Real sink in a *Test
 * file. Question: fires by default? does --exclude-tests suppress it?
 */
public class PathTravComboTest {

    public void run(HttpServletRequest req) throws Exception {
        new FileInputStream("/srv/app/data/" + req.getParameter("name")); // real CWE-22 in a *Test file
    }
}
