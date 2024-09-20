package com.myfirst_springapp.springapp;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    
    @Override
    public String getDailyWorkout(){
        return "Practice bowling.";
    }

}
