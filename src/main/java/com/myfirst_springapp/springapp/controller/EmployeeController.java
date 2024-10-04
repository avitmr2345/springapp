// package com.spring_security.springboot.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import com.spring_security.springboot.entity.Employee;
// import com.spring_security.springboot.service.EmployeeService;
// import java.util.List;

// @Controller
// @RequestMapping("/employees")
// public class EmployeeController {

//     private EmployeeService employeeService;

//     public EmployeeController(EmployeeService theEmployeeService) {
//         employeeService = theEmployeeService;
//     }

//     @GetMapping("/list")
//     public String listEmployees(Model theModel) {

//         List<Employee> theEmployees = employeeService.findAll();

//         // add to the spring model
//         theModel.addAttribute("employees", theEmployees);

//         return "employees/list-employees";
//     }
// }