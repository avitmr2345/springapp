package com.myfirst_springapp.springapp.rest;

import java.util.List;
import java.util.ArrayList;
import com.myfirst_springapp.springapp.entity.Employee;
import com.myfirst_springapp.springapp.entity.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exception) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad Request: Please provide an integer");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
