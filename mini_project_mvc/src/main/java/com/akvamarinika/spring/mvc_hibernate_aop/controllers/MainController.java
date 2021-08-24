package com.akvamarinika.spring.mvc_hibernate_aop.controllers;

import com.akvamarinika.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {
    EmployeeDAO employeeDAO;

    @Autowired
    public MainController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    private String getPageAllEmployees(Model model){
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        model.addAttribute("empList", employeeList);
        return "view-all-employees";
    }
}
