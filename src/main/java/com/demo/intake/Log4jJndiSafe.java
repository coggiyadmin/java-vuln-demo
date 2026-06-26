package com.demo.intake;

/** Safe mirror — constant JNDI name only; no user-controlled lookup. */
public class Log4jJndiSafe {
    public Object lookup() throws Exception {
        return new javax.naming.InitialContext().lookup("java:comp/env/jdbc/main");
    }
}
