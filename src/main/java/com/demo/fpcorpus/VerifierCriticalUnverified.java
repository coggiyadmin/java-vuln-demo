// FP-target (cognium-ai#122) — when the verifier returns llm_verified=false, the finding must
// NOT ship as severity=critical (the verifier's negative signal must be honored).
package com.demo.fpcorpus;
public class VerifierCriticalUnverified {
    // Constant query — a verifier would mark llm_verified=false; must not be critical sql_injection.
    public String list() { return "SELECT id, name FROM items ORDER BY name"; }
}
