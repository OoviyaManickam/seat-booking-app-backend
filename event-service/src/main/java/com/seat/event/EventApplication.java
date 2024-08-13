package com.seat.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.seat.event.prerequisites.PopulateTables;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
@EnableDiscoveryClient
public class EventApplication {

	@Autowired
	PopulateTables preRequisites;

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}

	// @Override
	// public void run(ApplicationArguments args) throws Exception {
	// 	preRequisites.initialize();
	// }

}
