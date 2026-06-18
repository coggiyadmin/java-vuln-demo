package com.demo.xf;

import java.util.logging.Logger;

public class XfLogInjHelper {
    private static final Logger LOG = Logger.getLogger("app");

    public static void run(String actor) {
        LOG.info("login by " + actor); // SINK CWE-117
    }
}
