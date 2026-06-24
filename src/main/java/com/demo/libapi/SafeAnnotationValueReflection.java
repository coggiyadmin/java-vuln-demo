// FP-target (upstream cognium-dev#159) — reflection target comes from a hardcoded annotation
// .value() constant, fully constant-propagable, not user input.
package com.demo.libapi;

import java.lang.annotation.*;

public class SafeAnnotationValueReflection {
    @Retention(RetentionPolicy.RUNTIME)
    @interface Handler { String value(); }
    @Handler("com.example.OrderHandler")
    static class Wired {}
    public Class<?> resolve() throws Exception {
        String name = Wired.class.getAnnotation(Handler.class).value(); // constant
        return Class.forName(name);
    }
}
