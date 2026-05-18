package com.jocata.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * API Gateway Service
 * 
 * This service acts as the single entry point for all client requests.
 * It handles routing, security, and cross-cutting concerns.
 * 
 * Key Features:
 * - Request Routing: Routes requests to appropriate microservices
 * - Security: Validates JWT tokens and enforces authentication
 * - Load Balancing: Distributes load across service instances
 * - Rate Limiting: Can implement rate limiting and throttling
 * - Monitoring: Centralized logging and monitoring
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}
