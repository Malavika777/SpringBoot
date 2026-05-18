package com.jocata.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Service Discovery Server
 * 
 * This service acts as a registry where all microservices register themselves.
 * Other services can discover and communicate with each other through Eureka.
 * 
 * Key Features:
 * - Service Registration: Services register themselves with Eureka
 * - Service Discovery: Services can find other services by name
 * - Health Monitoring: Monitors the health of registered services
 * - Load Balancing: Provides service instances for load balancing
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}

}
