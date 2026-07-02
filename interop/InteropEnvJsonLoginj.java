package com.demo.interop;
import com.fasterxml.jackson.databind.*;
import java.util.logging.*;

/** IL-61 — JSON env/config blob → log sink (IL-5 frontier). */
public class InteropEnvJsonLoginj {
    public void audit(String blob) throws Exception {
        JsonNode node = new ObjectMapper().readTree(blob);
        String user = node.get("user").asText();
        String pw = node.get("pw").asText();
        Logger.getLogger("app").info("login user=" + user + " password=" + pw);
    }
}
