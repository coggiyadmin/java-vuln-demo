package com.demo.intake;

import org.springframework.web.bind.annotation.*;

/** Safe mirror — explicit @RequestBody binding suppresses Spring4Shell pass. */
@RestController
@RequestMapping("/intake/safe")
public class Spring4ShellSafe {
    public static class UserDto {
        public String name;
        public String email;
    }

    @PostMapping("/users")
    public String createUser(@RequestBody UserDto user) {
        return "created: " + user.name;
    }
}
