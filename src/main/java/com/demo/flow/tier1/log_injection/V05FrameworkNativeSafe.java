package com.demo.flow.tier1.log_injection;
import org.slf4j.*;
import javax.servlet.http.*;
public class V05FrameworkNativeSafe {
    private static final Logger log = LoggerFactory.getLogger(V05FrameworkNativeSafe.class);
    public void logUser(HttpServletRequest req) {
        String user = req.getParameter("user").replaceAll("[\r\n\t]", "_");
        log.info("user={}", user);
    }
}
