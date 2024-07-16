package com.bondith.webappbackend.controller;

import com.bondith.webappbackend.model.User;
import com.bondith.webappbackend.service.UserAccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * The AppController class is a controller class that handles HTTP requests and returns responses.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserAccountController {

    @Autowired
    public UserAccountService userAccountService;

    @GetMapping("api/login")
    public void login() {
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userAccountService.save(user);
    }

}
