package com.springsecurity.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoSecurityController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "bootstrap_loginForm";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "accessDeniedPage";
    }

    @GetMapping("/leaders")
    public String showLeadersPage() {
        return "leaders";
    }
}
