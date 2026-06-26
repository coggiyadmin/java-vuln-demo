package com.demo.library_api;

import java.util.ServiceLoader;

/** TN — SPI ServiceLoader load is not injection (#165). */
public class BenignServiceLoader {
    public static void loadProviders() {
        ServiceLoader.load(Runnable.class).forEach(Runnable::run);
    }
}
