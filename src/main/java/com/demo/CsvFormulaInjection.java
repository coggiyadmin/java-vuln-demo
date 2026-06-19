package com.demo;

import java.io.FileWriter;
import javax.servlet.http.HttpServletRequest;

/** CWE-1236 — CSV Formula Injection. User input written into a CSV cell beginning with
 * =,+,-,@ executes as a spreadsheet formula. (Engine gap.) FN probe. */
public class CsvFormulaInjection {
    public void export(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");   // SOURCE
        try (FileWriter w = new FileWriter("/var/app/export.csv", true)) {
            w.write(name + ",100\n");              // '=cmd|...' becomes a formula → CWE-1236
        }
    }
}
