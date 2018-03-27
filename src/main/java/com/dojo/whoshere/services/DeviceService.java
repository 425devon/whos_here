package com.dojo.whoshere.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.whoshere.models.Device;
import com.dojo.whoshere.repositories.DeviceRepository;

@Service
public class DeviceService {
	private DeviceRepository deviceRepository;
	
	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public List<Device> findAll() {
		return deviceRepository.findAll();
	}
	
	public void saveDevice(Device device) {
		System.out.println(device);
		System.out.println(device.getMacAddress());
		deviceRepository.save(device);
	}
}