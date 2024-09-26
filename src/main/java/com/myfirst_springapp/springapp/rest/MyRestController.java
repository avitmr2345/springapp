package com.myfirst_springapp.springapp.rest;

import java.util.List;
import java.util.ArrayList;
import com.myfirst_springapp.springapp.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private List<Employee> theEmployees;

    @PostConstruct
    public void loadData() {
        theEmployees = new ArrayList<>();

        theEmployees.add(new Employee("Avish", "Tomar"));
        theEmployees.add(new Employee("Avi", "Tomar"));
        theEmployees.add(new Employee("A", "Tomar"));
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return theEmployees;
    }

}
