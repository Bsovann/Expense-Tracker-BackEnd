package com.bondith.webappbackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The AppController class is a controller class that handles HTTP requests and returns responses.
 */
@RestController
public class UserAccountController {

    @GetMapping("/")
    public String index(HttpServletRequest req) {
        return "Hello World! " + req.getSession().getId();
    }

}
