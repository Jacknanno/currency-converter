package com.jack.currencyconverter.service;

import com.jack.currencyconverter.model.User;
import com.jack.currencyconverter.respository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
// This is a service class that handles user registration and authentication. It uses a UserRepository to interact with the database and a PasswordEncoder to securely hash passwords before storing them.
    public AuthService(UserRepository repository ,PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
// The register method checks if a user with the given username already exists in the database. If the user exists, it returns a message indicating that the user already exists. If not, it encodes the password using the PasswordEncoder, creates a new User object, saves it to the database, and returns a success message.
    public String register(String username, String password) {

        if (repository.findByUsername(username) != null) {
            return "User already exists";
        }

        String encodedPassword = passwordEncoder.encode(password);
        
        User user = new User(username, encodedPassword);

        repository.save(user);
        return "User registered successfully";

    }


}
