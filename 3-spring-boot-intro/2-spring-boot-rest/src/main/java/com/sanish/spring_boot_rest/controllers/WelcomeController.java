package com.sanish.spring_boot_rest.controllers;

import com.sanish.spring_boot_rest.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcomeGreeting(){
        return "Hello Newbie Spring Developer";
    }

    @GetMapping("/accepted-route")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String accRoute(){
        return "Accepted Route requested from dev.";
    }

    @PostMapping("/order")
    public String giveData(@RequestBody Order order){
        return "Order data received is : "+order.toString();
    }

    @GetMapping("/hello/{u-name}")
    public String pathVar(
            @PathVariable("u-name") String userName){
        return "Hello "+userName;
    }
}
