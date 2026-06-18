package com.demo;

import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — OopFlowDeserialize; the blob is treated as opaque data (decoded only),
 * never deserialized into an object graph. Expect 0 security findings.
 */
public class SafeOopFlowDeserialize {

    private final String blob;

    public SafeOopFlowDeserialize(HttpServletRequest req) {
        this.blob = req.getParameter("s");
    }

    public int loadDirect() {
        byte[] b = Base64.getDecoder().decode(this.blob);   // decode only, no readObject
        return b.length;
    }
}
