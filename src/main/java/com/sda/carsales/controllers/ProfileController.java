package com.sda.carsales.controllers;

import com.sda.carsales.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private EmployeeService employeeService;

    @Autowired
    public ProfileController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/profile")
    public String profile(Model model, Principal principal){

        String un=principal.getName();
        model.addAttribute("employee",employeeService.findByUsername(un));
        return "profile";
    }
}
