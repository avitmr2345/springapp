package com.myfirst_springapp.springapp.dao;

import java.util.List;
import com.myfirst_springapp.springapp.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}