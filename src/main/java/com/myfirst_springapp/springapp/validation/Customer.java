package com.myfirst_springapp.springapp.validation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    // validation rules
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;
    
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater or equal to 0")
    @Max(value = 10, message = "must be less or equal to 10")
    private Integer freePasses;

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
