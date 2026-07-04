package com.demo.variants.xss;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
@RestController
public class V63SpringResponsebody {
    @GetMapping(value = "/p", produces = "text/html")
    @ResponseBody
    public String p(HttpServletRequest req) {
        String name = req.getParameter("name"); // SOURCE
        return "<h1>" + name + "</h1>"; // SINK CWE-79 @ResponseBody raw HTML
    }
}
