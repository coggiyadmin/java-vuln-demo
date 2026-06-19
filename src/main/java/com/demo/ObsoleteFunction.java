package com.demo;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-477 Use of Obsolete Function. The deprecated `Date.getYear()` API is used.
 * Real vuln; NO finding = FN.
 */
public class ObsoleteFunction {

    @SuppressWarnings("deprecation")
    public int year(HttpServletRequest request) {
        Date d = new Date();
        return d.getYear();                       // obsolete/deprecated API → CWE-477
    }
}
