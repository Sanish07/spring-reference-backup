package com.sanish.spring_dto_pattern.controller;

import com.sanish.spring_dto_pattern.dto.OrganizationDto;
import com.sanish.spring_dto_pattern.entity.Organization;
import com.sanish.spring_dto_pattern.service.OrganizationMapper;
import com.sanish.spring_dto_pattern.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organization")
    public ResponseEntity<List<OrganizationDto>> getAllOrganization(){
        //Customizing responses with DTO
        List<OrganizationDto> organizations = organizationService.getAllOrg();
        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @GetMapping("/organization/{org-id}")
    public ResponseEntity<Organization> getOrganizationById(
            @PathVariable("org-id") int id
    ){
        Organization fetchOrganization = organizationService.getOrgById(id);
        return new ResponseEntity<>(fetchOrganization, HttpStatus.OK);
    }

    @PostMapping("/organization")
    public ResponseEntity<Organization> saveNewOrganization(
            //DTOs will help us in customizing requests we expect and responses we send
            //We can use classes/records for making DTO files.
            @Valid @RequestBody OrganizationDto organizationDto
    ){
        Organization savedOrg = organizationService.addNewOrganization(organizationDto);
        return new ResponseEntity<>(savedOrg, HttpStatus.CREATED);
    } //This route has data validation passed at DTO level and handled exception

}
