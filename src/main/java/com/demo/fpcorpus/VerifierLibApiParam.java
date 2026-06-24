// FP-target (cognium-ai#109) — a public library-API method parameter is not an attacker source
// by itself; the verifier must not promote it to a critical exploitable finding.
package com.demo.fpcorpus;
public class VerifierLibApiParam {
    /** Public SDK method; `name` is supplied by the integrating application, not an HTTP request. */
    public String greet(String name) { return "hello " + name; } // not exploitable in isolation
}
