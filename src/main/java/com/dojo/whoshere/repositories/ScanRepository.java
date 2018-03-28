package com.dojo.whoshere.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.whoshere.models.Scan;

@Repository
public interface ScanRepository extends CrudRepository<Scan, Long> {
	List<Scan> findAll();
	
	@Query(value="SELECT hour, COUNT(*) FROM scans where device_id = ?1 GROUP BY hour", nativeQuery=true)
	List<Object[]> getScanTimesById(Long id);
	
	@Query(value="SELECT hour, COUNT(*) FROM scansGROUP BY hour", nativeQuery=true)
	List<Object[]> getScanTimesAllDevices();
	
	@Query(value="select devices.mac_address, count(*) from scans join devices on scans.device_id = devices.id where scans.created_at > date_sub(now(), INTERVAL 1 HOUR) group by scans.device_id order by count(*) DESC LIMIT 10", nativeQuery=true)
	List<Object[]> getTop10LastHour();
	
	@Query(value="select devices.mac_address, count(*) from scans join devices on scans.device_id = devices.id where scans.created_at > date_sub(now(), INTERVAL 1 DAY) group by scans.device_id order by count(*) DESC LIMIT 10", nativeQuery=true)
	List<Object[]> getTop10LastDay();
	
	@Query(value="select devices.mac_address, count(*) from scans join devices on scans.device_id = devices.id where scans.created_at > date_sub(now(), INTERVAL 1 WEEK) group by scans.device_id order by count(*) DESC LIMIT 10", nativeQuery=true)
	List<Object[]> getTop10LastWeek();
	
	@Query(value="select devices.mac_address, count(*) from scans join devices on scans.device_id = devices.id where scans.created_at > date_sub(now(), INTERVAL 1 MONTH) group by scans.device_id order by count(*) DESC LIMIT 10", nativeQuery=true)
	List<Object[]> getTop10LastMonth();
	
	@Query(value="select devices.mac_address, count(*) from scans join devices on scans.device_id = devices.id group by scans.device_id order by count(*) DESC LIMIT 10", nativeQuery=true)
	List<Object[]> getTop10AllTime();
}