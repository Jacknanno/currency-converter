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
   // The register method handles HTTP GET requests to the "/register" endpoint. It takes a username and password as request parameters,
   // calls the register method of the AuthService, and returns the result as a string response
    @PostMapping("/register")
    public String register(
        @RequestParam String username,
        @RequestParam String password) {

            return authService.register(username, password);
        }
   // The login method handles HTTP POST requests to the "/login" endpoint. It takes a username and password as request parameters,
   // calls the login method of the AuthService, and returns the result as a string response
    @GetMapping("/login")
    public String login(
        @RequestParam String username,
        @RequestParam String password) {
            return authService.login(username, password);
        }
        
}
