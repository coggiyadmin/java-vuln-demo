package com.demo.flow.tier1.log_injection;
import org.slf4j.*;
import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;
public class V08WrongContextTp {
    private static final Logger log = LoggerFactory.getLogger(V08WrongContextTp.class);
    public void logUser(HttpServletRequest req) {
        log.info("user={}", StringEscapeUtils.escapeHtml4(req.getParameter("user")));
    }
}
