package com.demo.benign_corpus;

import java.net.*;

/** TN — fetch allowlisted host only. */
public class BenignAllowlistHost {
    public boolean allowed(String url) throws Exception {
        return "api.internal.example.com".equals(new URL(url).getHost());
    }
}
