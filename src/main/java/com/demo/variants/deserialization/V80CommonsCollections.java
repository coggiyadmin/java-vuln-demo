package com.demo.variants.deserialization;

import org.apache.commons.collections.functors.InvokerTransformer;
import java.io.ObjectInputStream;
import javax.servlet.http.HttpServletRequest;
public class V80CommonsCollections {
    public Object read(HttpServletRequest req) throws Exception {
        // Untrusted stream deserialized with commons-collections on the classpath (gadget chain).
        return new ObjectInputStream(req.getInputStream()).readObject(); // SINK CWE-502 gadget
    }
}
