package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.OrganizationDto;
import com.sanish.spring_dto_pattern.entity.Organization;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationMapperTest {

    private OrganizationMapper organizationMapper;

    @BeforeEach
    void setUp(){
        organizationMapper = new OrganizationMapper();
    }

    @Test
    public void shouldMapOrganizationPojoToDto(){
        //Setting expected parameter
        Organization organization = new Organization("Tech Resolution",
                "Building tech solutions for the community.");

        //Calling the method we are testing
        OrganizationDto organizationDto = organizationMapper.pojoToDtoOrg(organization);

        //Comparing expected and actual values
        assertEquals(organization.getName(),organizationDto.name());
        assertEquals(organization.getDescription(),organizationDto.description());
    }

    @Test
    public void shouldMapOrganizationDtoToPojo(){
        OrganizationDto organizationDto = new OrganizationDto("AstonClass",
                "Newly launched tech company.");

        Organization organization = organizationMapper.dtoToPojoOrg(organizationDto);

        assertEquals(organizationDto.name(),organization.getName());
        assertEquals(organizationDto.description(),organization.getDescription());
    }
}