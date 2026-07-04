package com.demo.variants.open_redirect;

import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
public class V06SpringRedirectView {
    public RedirectView springRedirect(HttpServletRequest req) {
        String url = req.getParameter("url"); // SOURCE
        return new RedirectView(url); // SINK CWE-601 Spring RedirectView
    }
}
