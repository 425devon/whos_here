package com.dojo.whoshere.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.whoshere.models.Device;
import com.dojo.whoshere.repositories.DeviceRepository;
import com.dojo.whoshere.repositories.ScanRepository;

@Service
public class DeviceService {
	private DeviceRepository deviceRepository;
	private ScanRepository scanRepository;
	
	public DeviceService(DeviceRepository deviceRepository, ScanRepository scanRepository) {
		this.scanRepository = scanRepository;
		this.deviceRepository = deviceRepository;
	}

	public List<Device> findAll() {
		return deviceRepository.findAll();
	}
	
	public Device findByMacAddress(String macAddress) {
		return deviceRepository.findByMacAddress(macAddress);
	}
	
	public void saveDevice(Device device) {
		deviceRepository.save(device);
	}
	
	public List<Object[]> getScanTimesById(Long id) {
		return (List<Object[]>) scanRepository.getScanTimesById(id);
	}
}