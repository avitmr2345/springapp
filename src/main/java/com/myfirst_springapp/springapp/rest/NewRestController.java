package com.myfirst_springapp.springapp.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class NewRestController {

    @Value("${owner.name}")
    public String ownerName;
    
    @Value("${owner.surname}")
    public String ownerSurname;

    @GetMapping("owner")
    public String getOwnerInfor(){
        return "Owner: " + ownerName + ", Surname: " + ownerSurname;
    }
    
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/working")
    public String checkWorking() {
        return "It is working";
    }
}
