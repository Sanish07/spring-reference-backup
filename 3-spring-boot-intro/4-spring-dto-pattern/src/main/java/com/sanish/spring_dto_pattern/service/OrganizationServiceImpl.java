package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.OrganizationDto;
import com.sanish.spring_dto_pattern.entity.Organization;
import com.sanish.spring_dto_pattern.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public Organization getOrgById(int id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrganizationDto> getAllOrg() {
        return organizationRepository.findAll()
                .stream()
                .map(organizationMapper::pojoToDtoOrg)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Organization addNewOrganization(OrganizationDto organizationDto) {
        Organization org_pojo = organizationMapper.dtoToPojoOrg(organizationDto);
        return organizationRepository.save(org_pojo);
    }
}
