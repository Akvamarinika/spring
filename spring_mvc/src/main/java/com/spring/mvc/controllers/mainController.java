package com.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class mainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(){
        return "example-view";
    }

    @RequestMapping("/askDetails")
    public String askDetailsForm(){
        return "ask-detail";
    }

    @RequestMapping("/showDetails")
    public String showDetails(HttpServletRequest request, Model model){
        String yourName = request.getParameter("yourName1");
        yourName = "Mr. " + yourName;
        model.addAttribute("nameEmp", yourName);
        return "show-details";
    }

}
