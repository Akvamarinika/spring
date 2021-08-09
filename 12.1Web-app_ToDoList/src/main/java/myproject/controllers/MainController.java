package myproject.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return (new Date().toString());
    }
}
