// FP-target (upstream cognium-ai#111) — SQL text built inside a MyBatis Interceptor is
// framework-internal plumbing operating on already-parameterized statements, not app sqli.
package com.demo.libapi;

public class SafeMyBatisInterceptor {
    public interface Invocation { Object proceed() throws Throwable; Object[] getArgs(); }
    // Interceptor wraps MappedStatement; it does not concatenate user input into SQL.
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }
}
