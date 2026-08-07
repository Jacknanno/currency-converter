package com.jack.currencyconverter.model;

import jakarta.persistence.*;

@Entity
public class User {

    // Marks primary key and auto-generates the value for the id field.
    @Id
    // Specifies that the primary key should be generated automatically by the database using an identity column.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Declares a private field named id of type Long to store the unique identifier for each User entity.
    private Long id;

    private String username;
    private String password;
    // Default constructor required by JPA for entity instantiation.
    public User() {
    }
    // Parameterized constructor to create a User object with specified username and password.
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // Getter methods to access the private fields of the User and password entity.
    public Long getId() {
        return id;
    }
    // Getter method to retrieve the username of the User entity.
    public String getUsername() {
        return username;
    }
// Getter method to retrieve the password of the User entity.
    public String getPassword() {
        return password;
    }



    
}
