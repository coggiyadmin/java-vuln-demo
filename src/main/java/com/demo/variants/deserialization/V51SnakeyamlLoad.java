package com.demo.variants.deserialization;

import org.yaml.snakeyaml.Yaml;
import javax.servlet.http.HttpServletRequest;
public class V51SnakeyamlLoad {
    public Object load(HttpServletRequest req) throws Exception {
        String body = new String(req.getInputStream().readAllBytes()); // SOURCE
        return new Yaml().load(body); // SINK CWE-502 SnakeYAML default constructor
    }
}
