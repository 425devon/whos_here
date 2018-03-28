package com.dojo.whoshere.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dojo.whoshere.models.Device;
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
    	Device device = deviceService.findByMacAddress(mac);
    	List<Object[]> scanDates = (List<Object[]>) deviceService.getScanTimesById(device.getId());
    	model.addAttribute("scanDates", scanDates);
    	model.addAttribute("device", device);
    	return "devicePage.jsp";
    }
    
    @RequestMapping("/top")
    public String top(Model model) {
    	model.addAttribute("top10LastHour", deviceService.getTop10LastHour());
    	model.addAttribute("top10LastDay", deviceService.getTop10LastDay());
    	model.addAttribute("top10LastWeek", deviceService.getTop10LastWeek());
    	model.addAttribute("top10LastMonth", deviceService.getTop10LastMonth());
    	model.addAttribute("top10AllTime", deviceService.getTop10AllTime());
		return "topPage.jsp";
    }
}