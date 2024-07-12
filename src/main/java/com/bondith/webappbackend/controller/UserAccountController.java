package com.bondith.webappbackend.controller;

import com.bondith.webappbackend.model.User;
import com.bondith.webappbackend.service.UserAccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * The AppController class is a controller class that handles HTTP requests and returns responses.
 */
@RestController
public class UserAccountController {

    @Autowired
    public UserAccountService userAccountService;

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userAccountService.save(user);
    }

}
