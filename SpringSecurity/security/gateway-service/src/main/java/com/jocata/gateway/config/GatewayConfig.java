package com.jocata.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Gateway Configuration
 *
 * This class configures the routing rules for the API Gateway.
 * It defines how requests are routed to different microservices.
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route to Auth Service
                .route("auth-service", r -> r
                        .path("/auth/**")
                        .uri("lb://auth-service"))

                // Route to User Management Service
                .route("user-service", r -> r
                        .path("/users/**")
                        .uri("lb://user-management-service"))

                // Route to any other service
                .route("default-route", r -> r
                        .path("/**")
                        .uri("lb://user-management-service"))
                .build();
    }
}