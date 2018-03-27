package com.dojo.whoshere.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dojo.whoshere.models.Device;
import com.dojo.whoshere.services.DeviceService;

@Component
public class Schedule {    
	private DeviceService deviceService;
	
	public Schedule(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	@Scheduled(cron = "0,30 * * * * ?")
	public void scheduledTask() {
		System.out.println("scheduled job is starting");
		try {
			Process p = Runtime.getRuntime().exec("sudo arp-scan --localnet");
			
			BufferedReader stdInput = new BufferedReader(new 
				     InputStreamReader(p.getInputStream()));
			
			
			// read the output from the command and add to a list
			System.out.println("Here is the standard output of the command:\n");
			String s = null;
			ArrayList<String> parsedData = new ArrayList<String>();
			while ((s = stdInput.readLine()) != null) {
			    parsedData.add(s);
			}
			
			//call dataCleaner to remove header and footer statements for arp scanner
			List<String> cleanedData = dataCleaner(parsedData);
			for(int i=0;i<cleanedData.size();i++) {
				String[] fields = cleanedData.get(i).split("\t");
				Device newDevice = new Device(fields[0], fields[1], fields[2]);
				System.out.println(newDevice.getIpAddress());
				System.out.println(newDevice.getNickName());
				System.out.println(newDevice.getMacAddress());
				deviceService.saveDevice(newDevice);
			}
		} catch (IOException e) {
			System.out.println("this was not the cli call you were looking for...");
			e.printStackTrace();
		}
	}
	
	public static List<String> dataCleaner(List<String> data) {
		ArrayList<String> cleanData = (ArrayList<String>) data;
		
		for(int i = 0; i<3; i++) {
			cleanData.remove(0);
		}
		for(int n = 0; n < 5; n++) {
			cleanData.remove(cleanData.size()-1);
		}
		
		return cleanData;
	}
}