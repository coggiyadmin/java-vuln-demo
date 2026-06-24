// FP-target (upstream cognium-dev#160) — a no-arg constructor.newInstance() of a constant class
// carries no payload and is not reflection injection.
package com.demo.libapi;

public class SafeNoArgNewInstance {
    public Object make() throws Exception {
        return java.util.ArrayList.class.getDeclaredConstructor().newInstance(); // constant class
    }
}
