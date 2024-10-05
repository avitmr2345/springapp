// package com.spring_security.springboot.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.RequestMapping;
// import com.spring_security.springboot.entity.Employee;
// import com.spring_security.springboot.service.EmployeeService;
// import java.util.List;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;

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

//     @GetMapping("/showFormForAdd")
//     public String showFormForAdd(Model theModel) {

//         // create model attribute to bind form data
//         Employee theEmployee = new Employee();

//         theModel.addAttribute("employee", theEmployee);

//         return "employees/employee-form";
//     }

//     @PostMapping("/save")
//     public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

//         employeeService.save(theEmployee);

//         return "redirect:/employees/list";
//     }

//     @GetMapping("/showFormForUpdate")
//     public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

//         Employee thEmployee = employeeService.findById(theId);

//         theModel.addAttribute("employee", thEmployee);

//         return "employees/employee-form";

//     }

// }