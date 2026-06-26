package com.demo.intake;

import javax.servlet.http.HttpServletRequest;

/** Safe mirror — allowlisted report labels only. */
public class MagnoliaCmdiSafe {
    public void run(HttpServletRequest req) throws Exception {
        String label = req.getParameter("label");
        String script;
        switch (label) {
            case "sync" -> script = "sync";
            case "reindex" -> script = "reindex";
            default -> throw new SecurityException("forbidden");
        }
        Runtime.getRuntime().exec(new String[] { "/opt/app/bin/job.sh", script });
    }
}
