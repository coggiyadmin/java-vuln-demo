// FP-target (upstream cognium-dev#170, CRITICAL) — executeCommand is a RESP *protocol* verb
// (GET/SET), never an OS command. Must not be flagged command_injection (CWE-78).
package com.demo.libapi;

public class SafeRedisProtocolCommand {
    public interface RedisClient { Object executeCommand(String verb, String... args); }
    public Object cacheGet(RedisClient client, String key) {
        return client.executeCommand("GET", key); // protocol verb, NOT OS exec
    }
}
