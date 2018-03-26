package com.dojo.whoshere.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
	@Scheduled(cron = "0 * * * * ?")
	public void scheduledTask() {
		System.out.println("scheduled job is starting");
	}
}