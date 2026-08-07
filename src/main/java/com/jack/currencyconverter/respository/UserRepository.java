package com.jack.currencyconverter.respository;

import com.jack.currencyconverter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}
