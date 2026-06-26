package com.demo;

import java.io.*;

/** SAFE mirror — CsvFormulaInjection. Prefix with ' so spreadsheet treats cell as text. */
public class SafeCsvFormulaInjection {
    public void export(String name) throws IOException {
        String safe = name.isEmpty() ? "" : "'" + name;
        try (Writer w = new FileWriter("/var/app/export.csv", true)) {
            w.write(safe + ",100\n");
        }
    }
}
