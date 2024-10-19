package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.entity.Organization;
import com.sanish.spring_dto_pattern.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization getOrgById(int id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Organization> getAllOrg() {
        return organizationRepository.findAll();
    }

    @Override
    @Transactional
    public Organization addNewOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }
}
