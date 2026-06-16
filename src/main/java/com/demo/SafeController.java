package com.demo;

import org.springframework.web.bind.annotation.*;

/**
 * NEGATIVE TEST FILE — Spring controllers that are NOT Spring4Shell-vulnerable.
 *
 * Every handler either binds via @RequestBody/@RequestParam/@ModelAttribute,
 * or takes only scalar parameters. The scanner MUST produce ZERO `spring4shell`
 * findings here. Any finding is a FALSE POSITIVE.
 */
@RestController
@RequestMapping("/safe")
public class SafeController {

    // SAFE — scalar parameters only, no implicit POJO binding
    @GetMapping("/greet")
    public String greet(@RequestParam String name, @RequestParam int count) {
        return "hello " + name + " x" + count;
    }

    // SAFE — POJO bound explicitly via @RequestBody (JSON, not form-data reflection)
    @PostMapping("/users")
    public String createUser(@RequestBody UserDto user) {
        return "created " + user.name;
    }

    // SAFE — POJO bound explicitly via @ModelAttribute (suppresses Spring4Shell pass)
    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute @Valid ProfileForm form) {
        return "updated " + form.title;
    }

    // SAFE — @PathVariable scalar
    @GetMapping("/item/{id}")
    public String getItem(@PathVariable long id) {
        return "item " + id;
    }

    public static class UserDto {
        public String name;
        public String email;
    }

    public static class ProfileForm {
        public String title;
        public String bio;
    }
}
