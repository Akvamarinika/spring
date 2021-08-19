package com.spring.mvc.controllers;

import com.spring.mvc.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class mainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(){
        return "example-view";
    }

    @RequestMapping("/askDetails")
    public String askDetailsForm(Model model){
        model.addAttribute("empObj", new Employee());
        return "ask-detail";
    }

    @RequestMapping("/showDetails")
    public String showDetails(@ModelAttribute("empObj") Employee emp, Model model){
        emp.setName("Mr. " + emp.getName());
        return "show-details";
    }

}
