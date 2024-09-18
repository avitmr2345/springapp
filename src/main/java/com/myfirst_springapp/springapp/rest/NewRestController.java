package com.myfirst_springapp.springapp.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class NewRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

}
