package com.myfirst_springapp.springapp.rest;

import java.util.List;
import java.util.ArrayList;
import com.myfirst_springapp.springapp.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // @PathVariable will link the method parameter to the path variable
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        if ((employeeId >= theEmployees.size()) || (employeeId < 0)) {
            throw new EmployeeNotFoundException("Employee id " + employeeId + " not found");
        }

        return theEmployees.get(employeeId);
    }
}
