package com.demo.variants.open_redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class V06DjangoRedirect {
    @GetMapping("/go")
    public RedirectView go(@RequestParam String next) {
        return new RedirectView(next); // SINK CWE-601 Spring RedirectView
    }
}
