package com.myfirst_springapp.springapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.myfirst_springapp.springapp.Coach;

@RestController
public class DemoController {
    private Coach myCoach;

    // @Autowired
    // public DemoController(Coach theCoach) {
    // myCoach = theCoach;
    // }

    @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
