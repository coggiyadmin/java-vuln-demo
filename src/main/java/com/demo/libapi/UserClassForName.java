// TP (CWE-470) — genuine unsafe reflection: Class.forName on user-controlled name.
package com.demo.libapi;

public class UserClassForName {
    public Object make(String userClassName) throws Exception {
        return Class.forName(userClassName).getDeclaredConstructor().newInstance(); // SINK
    }
}
