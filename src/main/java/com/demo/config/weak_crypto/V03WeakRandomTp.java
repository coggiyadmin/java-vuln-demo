package com.demo.config.weak_crypto;

import java.util.Random;
public class V03WeakRandomTp {
    public int token() { return new Random().nextInt(1_000_000); } // SINK CWE-330
}
