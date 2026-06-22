// IL-1 polyglot — SAFE mirror of InteropThymeleaf.java.
// The value is HTML-escaped before it reaches the model, and the template uses
// th:text (escaped) rather than th:utext. ZERO security findings expected.
package com.demo.interop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

@Controller
public class SafeInteropThymeleaf {

    @GetMapping("/search")
    public String search(@RequestParam("q") String q, Model model) {
        // Safe: HTML-escape before the value reaches the view layer.
        model.addAttribute("query", HtmlUtils.htmlEscape(q));
        // Template "safe_results" renders ${query} via th:text (escaped output).
        return "safe_results";
    }
}
