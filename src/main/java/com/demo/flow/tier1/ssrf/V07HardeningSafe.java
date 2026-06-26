package com.demo.flow.tier1.ssrf;
import java.net.*; import java.util.Set; import javax.servlet.http.*;
public class V07HardeningSafe {
    private static final Set<String> BLOCK = Set.of("127.0.0.1", "169.254.169.254");
    public void fetch(HttpServletRequest req) throws Exception {
        URL url = new URL(req.getParameter("url"));
        String host = url.getHost();
        if (BLOCK.contains(host) || !host.endsWith(".example.com")) throw new SecurityException();
        url.openStream();
    }
}
