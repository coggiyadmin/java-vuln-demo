package com.demo.intake;

import org.springframework.web.bind.annotation.*;

/** TP — Spring4Shell implicit POJO binding (CWE-94 intake pattern). CVE-2022-22965 class. */
@RestController
@RequestMapping("/intake")
public class Spring4ShellTp {
    public static class UserForm {
        private String name;
        private Object metadata;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public Object getMetadata() { return metadata; }
        public void setMetadata(Object metadata) { this.metadata = metadata; }
    }

    @PostMapping("/users")
    public String createUser(UserForm user) { // SINK spring4shell / CWE-94
        return "created: " + user.getName();
    }
}
