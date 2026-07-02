// FP-target (upstream cognium-dev#170) — Jedis#get is a Redis key lookup (RESP GET),
// not an OS command. Real jedis type for faithful #170 reproduction.
package com.demo.libapi;

import redis.clients.jedis.Jedis;

public class SafeJedisGet {
    public String cacheGet(Jedis jedis, String key) {
        return jedis.get(key); // protocol verb GET, NOT OsCommandExec
    }
}
