package com.demo.xf;

import java.io.InputStream;
import java.net.URL;

public class XfSsrfHelper {
    public static InputStream run(String url) throws Exception {
        return new URL(url).openStream(); // SINK CWE-918
    }
}
