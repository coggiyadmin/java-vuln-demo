package com.demo.variants.format_string;

import org.apache.logging.log4j.LogManager;
import javax.servlet.http.HttpServletRequest;
public class V03LogFormat {
    public void log(HttpServletRequest req) {
        String user = req.getParameter("user");
        LogManager.getLogger().info(String.format("user=%s", user)); // SINK CWE-134 format string in log
    }
}
