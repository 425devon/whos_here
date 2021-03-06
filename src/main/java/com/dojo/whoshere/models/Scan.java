package com.dojo.whoshere.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="scans")
public class Scan {
	@Id
	@GeneratedValue
	private Long id;
	private String ipAddress;
    @DateTimeFormat(pattern = "MM dd, yyyy")
	private Date createdAt;
    private Long hour;
    
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="device_id")
	private Device device;
	
	public Scan() {
		this.createdAt = new Date();
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Long getHour() {
		return hour;
	}

	public void setHour(Long hour) {
		this.hour = hour;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
}