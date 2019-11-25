package com.upz.controller;

import com.upz.dto.User;
import com.upz.process.UserProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserProcess up;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity home(@RequestBody User user) {
        return up.registerUser(user);
    }
}
