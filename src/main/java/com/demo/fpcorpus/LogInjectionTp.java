// TP (CWE-117) — log injection: untrusted input written to a log without neutralization.
package com.demo.fpcorpus;
import java.util.logging.Logger;
public class LogInjectionTp {
    private static final Logger LOG = Logger.getLogger("app");
    public void onLogin(String user) { LOG.info("login user=" + user); } // SINK (CWE-117)
}
