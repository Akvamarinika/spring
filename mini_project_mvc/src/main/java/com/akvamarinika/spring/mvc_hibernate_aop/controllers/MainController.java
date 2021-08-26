package com.akvamarinika.spring.mvc_hibernate_aop.controllers;

import com.akvamarinika.spring.mvc_hibernate_aop.entities.Department;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import com.akvamarinika.spring.mvc_hibernate_aop.services.DepartmentService;
import com.akvamarinika.spring.mvc_hibernate_aop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    EmployeeService employeeService;
    DepartmentService departmentService;

    @Autowired
    public MainController(EmployeeService employeeService, DepartmentService departmentService){
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String getPageAllEmployees(Model model){
        List<Employee> employeeList = employeeService.getAll();
        List<Department> departmentList = departmentService.getAll();
        model.addAttribute("empList", employeeList);
        model.addAttribute("empObj", new Employee());
        model.addAttribute("departmentList", departmentList);
        return "view-all-employees";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    private String saveNewEmployee(@ModelAttribute("empObj") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }
}
