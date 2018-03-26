package com.dojo.whoshere.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.whoshere.models.Device;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
    Device findByMacAddress(String macAddress);
}