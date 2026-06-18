package com.demo;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #5 — OOP OBJECT FLOW × INSECURE DESERIALIZATION (CWE-502).
 * Constructor-injected taint fed to ObjectInputStream.readObject. NO finding = FALSE NEGATIVE.
 */
public class OopFlowDeserialize {

    private final String blob;

    public OopFlowDeserialize(HttpServletRequest req) {
        this.blob = req.getParameter("s");
    }

    public String getBlob() {
        return this.blob;
    }

    public Object loadDirect() throws Exception {
        byte[] b = Base64.getDecoder().decode(this.blob);
        return new ObjectInputStream(new ByteArrayInputStream(b)).readObject();   // CWE-502
    }

    public Object loadViaGetter() throws Exception {
        byte[] b = Base64.getDecoder().decode(getBlob());
        return new ObjectInputStream(new ByteArrayInputStream(b)).readObject();   // CWE-502
    }
}
