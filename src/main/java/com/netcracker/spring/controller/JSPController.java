package com.netcracker.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPController {

    @GetMapping("/")
    public String allUsers(Model model) {
        return "users";
    }

    @GetMapping("/user")
    public String user(Model model) {
        return "user";
    }

}
