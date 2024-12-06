package org.sanish.method_auth.controllers;

import org.sanish.method_auth.security.condition_eval.Test2ConditionEval;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    private final Test2ConditionEval test2ConditionEval;

    public DemoController(Test2ConditionEval test2ConditionEval) {
        this.test2ConditionEval = test2ConditionEval;
    }

    //PreAuthorize annotation endpoints - Rules are applied before the method is called

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

    @GetMapping("/test1/{u_name}")
    @PreAuthorize("#username == authentication.name") //Authorize if path variable username is equal to logged-in user from security context
    public ResponseEntity<String> test1(@PathVariable("u_name") String username){
        var auth = SecurityContextHolder.getContext().getAuthentication().toString(); // Get security context info
        return new ResponseEntity<>(auth, HttpStatus.OK);
    }

    @GetMapping("/test2")
    @PreAuthorize("@test2ConditionEval.conditionForAuthorization()")
    //For complex condition checks we can allocate a seperate bean and verify like this
    public String test2(){
        return "test2";
    }


    //PostAuthorize annotation - Authorization rules are applied after the method is called
    //Rarely used - and used mainly when we need to restrict the access of the return value
    //We never use PostAuthorize for methods that change data

    @GetMapping("/test3")
    @PostAuthorize(" returnObject == 'banana' ") //This request would send response only when response to sent was 'banana' else would send back 403
    public String test3(){
        String[] objects = {"apple","banana"};
        double random_val = Math.random();

        String response = null;
        response = (random_val < 0.5) ? objects[0] : objects[1];

        System.out.println("Method is still executed..."); //Doesn't matter whether the response was sent or not, entire method would still be executed
        return response;
    }

    //PreFilter works when we accept list or Collection parameter in the method
    @GetMapping("/test4")
    @PreFilter(" filterObject.contains('a') ")
    public String test4(@RequestBody List<String> wordsList){
        System.out.println(wordsList); //Only those words would be printed from passed values in request body which contain 'a' as substring
        return "test4";
    }

    //Post Filter works when return type from method is a list or collection
    @GetMapping("/test5")
    @PostFilter(" filterObject.contains('a') ")
    public List<String> test5(){
        List<String> wordsList = new ArrayList<>();
        wordsList.add("rain");
        wordsList.add("snow");
        wordsList.add("evening");
        wordsList.add("fang");
        wordsList.add("box");
        wordsList.add("ball");

        return wordsList;
    }
}
