// FP-target (elarasu cognium-ai#111) — PLUGIN profile. A framework interceptor that rewrites
// already-parameterized statements. Framework-internal plumbing, not app-level sqli.
package com.demo.profile.plugin;

public final class SqlRewriteInterceptor {
    public interface Invocation { Object proceed() throws Throwable; }
    public Object intercept(Invocation inv, String boundSql) throws Throwable {
        // boundSql is a pre-compiled MappedStatement id, not user input concatenated into SQL
        return inv.proceed();
    }
}
