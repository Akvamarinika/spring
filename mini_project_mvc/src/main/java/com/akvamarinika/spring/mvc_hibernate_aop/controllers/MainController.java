package com.akvamarinika.spring.mvc_hibernate_aop.controllers;

import com.akvamarinika.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import com.akvamarinika.spring.mvc_hibernate_aop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {
    EmployeeService employeeService;

    @Autowired
    public MainController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private String getPageAllEmployees(Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("empList", employeeList);
        return "view-all-employees";
    }
}
