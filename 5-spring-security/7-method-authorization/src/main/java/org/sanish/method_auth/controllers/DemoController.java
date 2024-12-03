package org.sanish.method_auth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Method Authorization - This method is accessible to users having read authority
    //But since it has also a rule exclusive defined in SecurityFilterChain bean, both will apply as 'AND' condition
    @GetMapping("/hello")
    @PreAuthorize(" hasAuthority('read') ")
    public ResponseEntity<String> sayHello(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/start")
    @PreAuthorize(" hasAnyAuthority('read','write') ") //Acc. to users having read OR write authority
    public ResponseEntity<String> startRoute(){
        return new ResponseEntity<>("Welcome to start route...", HttpStatus.OK);
    }
}
