package com.myfirst_springapp.springapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.myfirst_springapp.springapp.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotheCoach;

    // @Autowired
    // public DemoController(Coach theCoach) {
    // myCoach = theCoach;
    // }

    @Autowired
    public void setCoach(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotheCoach = theAnotherCoach;
    }

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("Comparing beans: myCoach & anotherCoach, " + (myCoach == anotheCoach));
    }
    
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("Bean deleted.");
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
