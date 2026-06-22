// IL-1 polyglot — Java → Thymeleaf template (CWE-79).
// Host (Spring/Java) drives a Thymeleaf template that emits a request value via
// the *unescaped* th:utext / inlined [(...)] expression, bypassing Thymeleaf's
// default HTML escaping. Expected today: likely FN (template-EL sink not modeled).
package com.demo.interop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InteropThymeleaf {

    @GetMapping("/search")
    public String search(@RequestParam("q") String q, Model model) {
        model.addAttribute("query", q); // SOURCE (HTTP param)
        // The template "results" renders ${query} via th:utext (unescaped):
        //   <p th:utext="${query}">x</p>   <-- SINK (CWE-79): raw markup, no escaping
        return "results";
    }
}
