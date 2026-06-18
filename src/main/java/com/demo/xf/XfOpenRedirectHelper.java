package com.demo.xf;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class XfOpenRedirectHelper {
    public static void run(HttpServletResponse resp, String url) throws IOException {
        resp.sendRedirect(url); // SINK CWE-601
    }
}
