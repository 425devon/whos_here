package com.dojo.whoshere.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojo.whoshere.services.DeviceService;

@Controller
public class HomeController {
	private DeviceService deviceService;
	
    public HomeController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    
    @RequestMapping(value= {"/", "", "/home"})
    public String index(Model model) {
    	model.addAttribute("devices", deviceService.findAll());
        return "homePage.jsp";
    }
    
    @RequestMapping("/devices/{mac}")
    public String device(Model model, @PathVariable("mac") String mac) {
    	System.out.println(mac);
    	model.addAttribute("device", deviceService.findByMacAddress(mac));
    	return "devicePage.jsp";
    }
}