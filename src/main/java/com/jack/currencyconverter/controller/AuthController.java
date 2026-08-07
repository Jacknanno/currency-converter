package com.jack.currencyconverter.controller;

import com.jack.currencyconverter.service.AuthService;
import org.springframework.web.bind.annotation.*;
// The @RestController annotation indicates that this class is a RESTful controller, which means it will handle HTTP requests and return responses in JSON format.
@RestController
// The @RequestMapping annotation specifies that all requests to this controller will be prefixed with "/auth".
@RequestMapping("/auth")
// This class is responsible for handling authentication-related requests, such as login and registration.
public class AuthController {
    // The AuthService is injected into the controller through constructor injection. This service will handle the business logic related to authentication.
    public final AuthService authService;
    
    // This constructor is used to inject the AuthService dependency into the AuthController. 
    // It allows the controller to use the methods defined in the AuthService for authentication operations.
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    // The @PostMapping annotation indicates that this method will handle HTTP POST requests to the "/register" endpoint. It takes two parameters, 
    // username and password, which are expected to be provided in the request body.
    @GetMapping("/register")
    public String register(
        @RequestParam String username,
        @RequestParam String password) {

            return authService.register(username, password);
        }
    
}
