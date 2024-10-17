package com.sanish.spring_data_jpa.repositories;

import com.sanish.spring_data_jpa.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College,Integer> {
}
