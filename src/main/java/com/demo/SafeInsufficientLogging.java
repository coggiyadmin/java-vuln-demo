package com.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — InsufficientLogging.java; the privileged action is audit-logged with actor +
 * target + outcome.
 */
public class SafeInsufficientLogging {

    private static final Logger log = Logger.getLogger("app");

    public void deleteUser(HttpServletRequest request) {
        String target = request.getParameter("userId");
        String actor = request.getHeader("X-Actor");
        doDelete(target);
        String safeActor = actor == null ? "" : actor.replaceAll("[\\r\\n]", "");
        String safeTarget = target == null ? "" : target.replaceAll("[\\r\\n]", "");
        log.info("audit action=delete-user actor=" + safeActor + " target=" + safeTarget + " outcome=ok");
    }

    private void doDelete(String id) {}
}
