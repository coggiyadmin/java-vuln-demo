package com.demo.xf;

import java.io.FileInputStream;
import java.io.InputStream;

public class XfPathTravHelper {
    private static final String BASE = "/srv/app/data/";

    public static InputStream run(String name) throws Exception {
        return new FileInputStream(BASE + name); // SINK CWE-22
    }
}
