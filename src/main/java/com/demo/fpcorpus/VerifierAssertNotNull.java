// FP-target (cognium-ai#109/#123) — the LLM verifier must REJECT this: Assert.notNull is a
// validation guard, not a sql/code sink. Promoting it to exploitable sql_injection is a verifier FP.
package com.demo.fpcorpus;
import org.springframework.util.Assert;
public class VerifierAssertNotNull {
    public void handle(Object id) {
        Assert.notNull(id, "id required"); // guard — NOT an exploitable sink
    }
}
