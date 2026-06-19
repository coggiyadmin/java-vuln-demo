package com.demo;

import java.time.Year;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — ObsoleteFunction.java; uses the modern `java.time.Year` replacement.
 */
public class SafeObsoleteFunction {

    public int year(HttpServletRequest request) {
        return Year.now().getValue();             // modern, non-deprecated API
    }
}
