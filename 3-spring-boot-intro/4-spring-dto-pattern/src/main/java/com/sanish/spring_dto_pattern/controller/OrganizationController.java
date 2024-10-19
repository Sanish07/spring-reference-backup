package com.sanish.spring_dto_pattern.controller;

import com.sanish.spring_dto_pattern.entity.Organization;
import com.sanish.spring_dto_pattern.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organization")
    public ResponseEntity<List<Organization>> getAllOrganization(){
        List<Organization> organizations = organizationService.getAllOrg();
        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @GetMapping("/organization/{org-id}")
    public ResponseEntity<Organization> getAllOrganization(
            @PathVariable("org-id") int id
    ){
        Organization fetchOrganization = organizationService.getOrgById(id);
        return new ResponseEntity<>(fetchOrganization, HttpStatus.OK);
    }

    @PostMapping("/organization")
    public ResponseEntity<Organization> saveNewOrganization(
            @RequestBody Organization organization
    ){
        Organization savedOrg = organizationService.addNewOrganization(organization);
        return new ResponseEntity<>(savedOrg, HttpStatus.CREATED);
    }

}
