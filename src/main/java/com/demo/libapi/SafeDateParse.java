// FP-target (elarasu cognium-dev#155) — date parsing is not code execution.
package com.demo.libapi;

import java.time.LocalDate;

public class SafeDateParse {
    public LocalDate parse(String userDate) {
        return LocalDate.parse(userDate); // NOT a sink
    }
}
