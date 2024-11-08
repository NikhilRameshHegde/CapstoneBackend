package com.ust.ApiGateway.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        
        // Configure allowed origins, methods, headers, etc.
        corsConfig.addAllowedOrigin("http://localhost:4200");  // Add specific domains or use "*" for all
        corsConfig.addAllowedHeader("*");  // Allow all headers
        corsConfig.addAllowedMethod("*");  // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
        corsConfig.setAllowCredentials(true);  // Allow cookies or authorization headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);  // Apply CORS config to all routes

        return new CorsWebFilter(source);
    }
}
