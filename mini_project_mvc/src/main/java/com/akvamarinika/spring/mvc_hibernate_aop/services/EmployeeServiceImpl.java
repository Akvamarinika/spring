package com.akvamarinika.spring.mvc_hibernate_aop.services;

import com.akvamarinika.spring.mvc_hibernate_aop.dao.repositories.EmployeeDAO;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return  employeeDAO.getAll();
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public  Optional<Employee> get(Long id) {
        Optional<Employee> employee = employeeDAO.get(id);
        return employee;
    }

    @Override
    @Transactional
    public boolean delete(Long id){
        boolean answer = employeeDAO.delete(id);
        return answer;
    }
}
