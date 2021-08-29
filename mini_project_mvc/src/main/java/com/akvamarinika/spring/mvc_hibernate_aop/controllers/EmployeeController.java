package com.akvamarinika.spring.mvc_hibernate_aop.controllers;

import com.akvamarinika.spring.mvc_hibernate_aop.entities.Department;
import com.akvamarinika.spring.mvc_hibernate_aop.entities.Employee;
import com.akvamarinika.spring.mvc_hibernate_aop.services.DepartmentService;
import com.akvamarinika.spring.mvc_hibernate_aop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    EmployeeService employeeService;
    DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService){
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
//, produces = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value = "/employees/{empId}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Object> getEmployee(@PathVariable("empId") Long id){
        System.out.println(id);
        Optional<Employee> employee = employeeService.get(id);
        System.out.println(employee.get().getDepartment().getName());
        if (employee.isPresent()){
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
