// FP-target (upstream cognium-dev#156) — Velocity on a static template; user data at merge only.
package com.demo.libapi;

import java.io.StringWriter;
import java.util.Map;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

public class SafeVelocityRender {
    private static final VelocityEngine ENGINE = new VelocityEngine();

    static {
        ENGINE.setProperty(RuntimeConstants.RUNTIME_LOG_NAME, "velocity");
        ENGINE.init();
    }

    public String render(String userName) {
        VelocityContext ctx = new VelocityContext(Map.of("name", userName));
        StringWriter out = new StringWriter();
        ENGINE.evaluate(ctx, out, "greet", "<p>$name</p>"); // static template string
        return out.toString();
    }
}
