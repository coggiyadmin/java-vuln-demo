package com.demo.intake;

import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;

/** Safe mirror — classpath resource only; no user-controlled scheme/path. */
public class SpringCloudConfigPathSafe {
    public InputStream fetch() throws Exception {
        return new ClassPathResource("application.properties").getInputStream();
    }
}
