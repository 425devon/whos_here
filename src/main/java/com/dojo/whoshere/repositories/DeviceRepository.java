package com.dojo.whoshere.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.whoshere.models.Device;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
	List<Device> findAll();
    Device findByMacAddress(String macAddress);
}