package com.dojo.whoshere.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojo.whoshere.services.DeviceService;

@Controller
public class HomeController {
	private DeviceService deviceService;
	
    public HomeController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    
    @RequestMapping(value= {"/", "", "/home"})
    public String registerForm(Model model) {
    	model.addAttribute("devices", deviceService.findAll());
        return "homePage.jsp";
    }
}