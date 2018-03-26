package com.dojo.whoshere.services;

import org.springframework.stereotype.Service;

import com.dojo.whoshere.repositories.DeviceRepository;

@Service
public class DeviceService {
	private DeviceRepository deviceRepository;
	
	public DeviceService(DeviceRepository deviceRepostitory) {
		this.deviceRepository = deviceRepository;
	}
}