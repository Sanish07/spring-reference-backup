package org.sanish.matcher_methods.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/test1")
    public ResponseEntity<String> test1(){
        return new ResponseEntity<>("Test1 Route", HttpStatus.OK);
    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2(){
        return new ResponseEntity<>("Test1 Route", HttpStatus.OK);
    }

    @PostMapping("/test3")
    public String test3(){
        return "Test3 Route POST";
    }
}
