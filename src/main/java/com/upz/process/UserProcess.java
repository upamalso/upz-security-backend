package com.upz.process;

import com.upz.entity.User;
import com.upz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;


public class UserProcess {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity registerUser(Map<String, String> payload) {



        User user = new User();
        user.setUsername(payload.get("username"));
        user.setPassword(payload.get("password"));
        user.setActive(true);
        user.setRoles("USER");
        this.userRepository.save(user);
        if (user.getId() > 0) {
            return new ResponseEntity(user.getId(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(user.getId(), HttpStatus.CONFLICT);
        }

    }
}
