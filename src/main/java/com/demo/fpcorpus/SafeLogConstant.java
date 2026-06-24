// FP-target — logging a constant / non-tainted value must not be flagged log injection.
package com.demo.fpcorpus;
import java.util.logging.Logger;
public class SafeLogConstant {
    private static final Logger LOG = Logger.getLogger("app");
    public void start() { LOG.info("service started"); } // constant — NOT a sink
}
