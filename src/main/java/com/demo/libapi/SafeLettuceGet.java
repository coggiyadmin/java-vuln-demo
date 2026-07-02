// FP-target (upstream cognium-dev#170) — Lettuce sync GET is a Redis key lookup, not OS exec.
package com.demo.libapi;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.sync.RedisCommands;

public class SafeLettuceGet {
    public String cacheGet(RedisClient client, String key) {
        RedisCommands<String, String> cmd = client.connect().sync();
        return cmd.get(key); // protocol GET, NOT OsCommandExec
    }
}
