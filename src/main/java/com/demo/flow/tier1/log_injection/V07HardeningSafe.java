package com.demo.flow.tier1.log_injection;
import org.slf4j.*;
import javax.servlet.http.*;
public class V07HardeningSafe {
    private static final Logger log = LoggerFactory.getLogger(V07HardeningSafe.class);
    public void logUser(HttpServletRequest req) {
        String user = req.getParameter("user");
        if (user.length() > 64) throw new SecurityException();
        log.info("user={}", user);
    }
}
