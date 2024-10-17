package com.sanish.spring_data_jpa.controller;

import com.sanish.spring_data_jpa.entity.College;
import com.sanish.spring_data_jpa.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollegeController {

    private CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping("/colleges")
    public ResponseEntity<List<College>> getCollegeList(){
        List<College> fetchedColleges = collegeService.getAllColleges();
        return new ResponseEntity<>(fetchedColleges, HttpStatus.OK);
    }

    @PostMapping("/colleges")
    public ResponseEntity<College> addNewCollege(@RequestBody College college){
        College savedCollege = collegeService.addCollege(college);
        return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
    }
}
