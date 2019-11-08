package com.upz.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @RequestMapping(value = "/")
    public String home() {
        return "<h1>Welcome</h1>";
    }

    @RequestMapping(value = "/user")
    public String getUser() {
        return "<h1>Welcome user</h1>";
    }

    @RequestMapping(value = "/admin")
    public String getAdmin() {
        return "<h1>Welcome admin</h1>";
    }

}
