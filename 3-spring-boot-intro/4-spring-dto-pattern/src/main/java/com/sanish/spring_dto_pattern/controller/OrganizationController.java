package com.sanish.spring_dto_pattern.controller;

import com.sanish.spring_dto_pattern.dto.OrganizationDto;
import com.sanish.spring_dto_pattern.entity.Organization;
import com.sanish.spring_dto_pattern.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organization")
    public ResponseEntity<List<OrganizationDto>> getAllOrganization(){
        //Customizing responses with DTO
        List<OrganizationDto> organizations =
                organizationService.getAllOrg()
                        .stream()
                        .map(this::pojoToDtoOrg)
                        .collect(Collectors.toList());
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
            //DTOs will help us in customizing requests we expect and responses we send
            //We can use classes/records for making DTO files.
            @RequestBody OrganizationDto organizationDto
    ){
        Organization org_pojo = dtoToPojoOrg(organizationDto);
        Organization savedOrg = organizationService.addNewOrganization(org_pojo);
        return new ResponseEntity<>(savedOrg, HttpStatus.CREATED);
    }

    public OrganizationDto pojoToDtoOrg(Organization org){
        return new OrganizationDto(org.getName(), org.getDescription());
    }

    public Organization dtoToPojoOrg(OrganizationDto organizationDto){
        Organization organization = new Organization();
        organization.setName(organizationDto.name());
        organization.setDescription(organizationDto.description());
        return organization;
    }
}
