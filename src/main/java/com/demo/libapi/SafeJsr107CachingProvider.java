// FP-target (upstream cognium-dev#168) — JSR-107 spec-mandated ClassLoader.loadClass of a
// provider name resolved from the classpath, not user input.
package com.demo.libapi;

public class SafeJsr107CachingProvider {
    private static final String PROVIDER = "com.example.cache.DefaultCachingProvider";
    public Class<?> load() throws ClassNotFoundException {
        return Thread.currentThread().getContextClassLoader().loadClass(PROVIDER); // constant name
    }
}
