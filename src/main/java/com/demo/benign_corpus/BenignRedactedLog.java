package com.demo.benign_corpus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** TN — structured log. */
public class BenignRedactedLog {
    private static final Logger log = LoggerFactory.getLogger(BenignRedactedLog.class);
    public void logUser(String user) {
        log.info("event=user_lookup value={}", user.replaceAll("[\r\n\t]", "_"));
    }
}
