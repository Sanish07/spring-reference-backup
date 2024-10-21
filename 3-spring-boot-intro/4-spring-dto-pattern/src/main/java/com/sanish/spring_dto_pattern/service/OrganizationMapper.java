package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.OrganizationDto;
import com.sanish.spring_dto_pattern.entity.Organization;
import org.springframework.stereotype.Service;

@Service
public class OrganizationMapper {

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
