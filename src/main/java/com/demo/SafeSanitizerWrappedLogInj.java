package com.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/** c08 SAFE — custom wrapper × log injection (CWE-117). Expect clean. */
public class SafeSanitizerWrappedLogInj {
    private static String redact(String s) {
        return s.replace("\r", "_").replace("\n", "_").replace("\t", "_");
    }
    public void wrapped(HttpServletRequest req) {
        Logger.getLogger("app").info("user=%s", redact(req.getParameter("user")));
    }
}
