package com.akvamarinika.spring.mvc_hibernate_aop.dao;

import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
}
