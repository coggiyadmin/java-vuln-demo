package com.demo.taint.sources;
import redis.clients.jedis.Jedis;
public class SRC14_cache_read {
    public void handle(Jedis jedis, String key) throws Exception {
        String v = jedis.get(key); // SOURCE cache read (second-order)
        Runtime.getRuntime().exec("echo " + v); // SINK
    }
}
