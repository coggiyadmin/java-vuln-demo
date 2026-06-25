package com.demo.intake;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import javax.servlet.http.HttpServletRequest;

/** TP — path equivalence (internal dot) bypasses prefix check → unsafe deserialization (CWE-22 / CWE-502). */
public class PathDotDeserTp {
    private static final File UPLOAD_ROOT = new File("/var/app/uploads");

    public void uploadAndLoad(HttpServletRequest req) throws Exception {
        String filename = req.getParameter("name");
        File dest = new File(UPLOAD_ROOT, filename);
        if (dest.getPath().startsWith(UPLOAD_ROOT.getPath())) {
            try (FileOutputStream fos = new FileOutputStream(dest)) {
                fos.write(req.getParameter("body").getBytes());
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dest)); // SINK CWE-502
            ois.readObject();
        }
    }
}
