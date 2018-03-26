package com.dojo.whoshere.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.whoshere.models.Device;
import com.dojo.whoshere.repositories.DeviceRepository;

@Service
public class DeviceService {
	private DeviceRepository deviceRepository;
	
	public DeviceService(DeviceRepository deviceRepostitory) {
		this.deviceRepository = deviceRepository;
	}

	public List<Device> findAll() {
		return deviceRepository.findAll();
	}
}