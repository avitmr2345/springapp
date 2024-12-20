package com.spring_security.springboot.dao;

import com.spring_security.springboot.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();

}
