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
}