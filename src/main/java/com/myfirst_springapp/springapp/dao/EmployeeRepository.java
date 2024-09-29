package com.myfirst_springapp.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfirst_springapp.springapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
