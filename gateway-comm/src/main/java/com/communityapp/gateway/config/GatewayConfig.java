package com.communityapp.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("vendor-service", r -> r.path("/api/vendors/**")
                        .uri("lb://VENDOR-SERVICE"))
                
                .route("user-service", r -> r.path("/api/users/**")
                        .uri("lb://USER-SERVICE"))
                
                .route("product-service", r -> r.path("/api/products/**", "/api/categories/**", "/api/reviews/**")
                        .uri("lb://PRODUCT-SERVICE"))
                
                .route("order-service", r -> r.path("/api/orders/**", "/api/order-items/**")
                        .uri("lb://ORDER-SERVICE"))
                .build();
    }
}
