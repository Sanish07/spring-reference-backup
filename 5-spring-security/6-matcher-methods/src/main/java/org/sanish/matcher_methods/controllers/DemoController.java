package org.sanish.matcher_methods.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("Hello World GET", HttpStatus.OK);
    }

    @PostMapping("/hello")
    public ResponseEntity<String> sayHelloPost() {
        return new ResponseEntity<>("Hello World POST", HttpStatus.OK);
    }

    @GetMapping("/start")
    public ResponseEntity<String> start() {
        return new ResponseEntity<>("Welcome to start route", HttpStatus.OK);
    }

    @GetMapping("/end")
    public ResponseEntity<String> end() {
        return new ResponseEntity<>("Welcome to end route", HttpStatus.OK);
    }

}
