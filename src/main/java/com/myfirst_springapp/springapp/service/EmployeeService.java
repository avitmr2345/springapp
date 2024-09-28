package com.myfirst_springapp.springapp.service;

import java.util.List;
import com.myfirst_springapp.springapp.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
