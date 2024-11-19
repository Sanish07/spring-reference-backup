package com.sanish.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class FirstController {

    @GetMapping("/dog")
    public String firstMethod(){
        return "Hello";
    }
}
