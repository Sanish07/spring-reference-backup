package com.sanish.managing_users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/get1")
    public ResponseEntity<String> getUser(){


        return new ResponseEntity<>("abc", HttpStatus.OK);
    }
}
