package com.sanish.spring_dto_pattern.controller;

import com.sanish.spring_dto_pattern.dto.EmployeeDto;
import com.sanish.spring_dto_pattern.entity.Employee;
import com.sanish.spring_dto_pattern.entity.Organization;
import com.sanish.spring_dto_pattern.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{emp-id}")
    public ResponseEntity<Employee> getEmpById(
            @PathVariable("emp-id") int id){
        Employee fetchedEmp = employeeService.getEmpById(id);
        return new ResponseEntity<>(fetchedEmp, HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmps(){
        List<Employee> fetchedEmps = employeeService.getAllEmp();
        return new ResponseEntity<>(fetchedEmps, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveNewEmp(
            @RequestBody EmployeeDto employeeDto){ //We receive EmployeeDto which also has org_id
        Employee savedEmp = employeeService.addNewEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp,HttpStatus.CREATED);
    }


}
