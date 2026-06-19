package com.demo;

import java.net.URL;
import java.util.Scanner;

/** CWE-494 — Download of Code Without Integrity Check. A script is fetched and executed with
 * no signature/hash verification. (Engine gap — cf #93.) FN probe. */
public class DownloadWithoutIntegrity {
    public void selfUpdate() throws Exception {
        String code;
        try (Scanner s = new Scanner(new URL("http://updates.internal/install.sh").openStream())) {
            code = s.useDelimiter("\\A").next();
        }
        Runtime.getRuntime().exec(new String[]{"bash", "-c", code});   // unverified downloaded code → CWE-494
    }
}
