package com.communityapp.gateway.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
    
    // List of open routes that don't require authentication
    public static final List<String> OPEN_ROUTES = List.of(
        "/api/users/login",
        "/api/vendors/login",
        "/api/users/register",
        "/api/vendors/register"
    );

    // Predicate to check if the route is secured (i.e., needs token validation)
    public Predicate<ServerHttpRequest> isSecured = request -> OPEN_ROUTES.stream()
        .noneMatch(route -> request.getURI().getPath().contains(route));  // Returns true for secured routes
}
