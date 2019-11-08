package com.upz.controller;

import com.upz.process.UserProcess;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    private UserProcess up;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity home(@RequestBody Map<String, String> payload) {
        up = new UserProcess();
        return up.registerUser(payload);
    }
}
