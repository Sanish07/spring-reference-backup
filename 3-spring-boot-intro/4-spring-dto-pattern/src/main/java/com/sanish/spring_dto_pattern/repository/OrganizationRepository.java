package com.sanish.spring_dto_pattern.repository;

import com.sanish.spring_dto_pattern.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
}
