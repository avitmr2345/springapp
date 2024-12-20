package com.spring_security.springboot.service;

import java.util.List;

import com.spring_security.springboot.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
