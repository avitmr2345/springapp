package com.myfirst_springapp.springapp;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run 5km regularly.";
    }
}
