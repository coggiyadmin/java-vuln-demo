package com.demo.config.hardcoded_secrets;

import java.util.Map;
public class V11PrivateKeySafe {
    public String loadKey(Map<String, String> secrets) {
        return secrets.get("private_key"); // injected from secrets manager, no literal
    }
}
