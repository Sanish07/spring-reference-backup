package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.OrganizationDto;
import com.sanish.spring_dto_pattern.entity.Organization;

import java.util.List;

public interface OrganizationService {
    Organization getOrgById(int id);

    List<OrganizationDto> getAllOrg();

    Organization addNewOrganization(OrganizationDto organizationDto);
}
