// FP-target (elarasu cognium-dev#165) — ServiceLoader loads classes named in trusted
// META-INF/services files shipped with the app, not from user input. Not reflection injection.
package com.demo.libapi;

import java.util.ServiceLoader;

public class SafeSpiServiceLoader {
    public interface Plugin { String name(); }
    public Iterable<Plugin> discover() {
        return ServiceLoader.load(Plugin.class); // SPI from trusted services file
    }
}
