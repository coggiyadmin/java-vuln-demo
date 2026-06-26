package com.demo.flow.tier1.log_injection;
import org.slf4j.*;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("\n", ""); }
    private static final Logger log = LoggerFactory.getLogger(V06CustomWrapperSafe.class);
    public void logUser(HttpServletRequest req) {
        log.info("user={}", companySanitize(req.getParameter("user")));
    }
}
