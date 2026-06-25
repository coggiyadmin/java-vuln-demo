package com.demo.intake;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.servlet.http.HttpServletRequest;

/** TP — management interface deserializes session blob from request param (CWE-502). */
public class MgmtIfaceDeserTp {
    public Object restoreSession(HttpServletRequest req) throws Exception {
        byte[] blob = req.getParameter("session").getBytes();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(blob)); // SINK CWE-502
        return ois.readObject();
    }
}
