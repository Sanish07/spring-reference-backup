package com.sanish.spring_data_jpa.services;

import com.sanish.spring_data_jpa.entity.College;
import com.sanish.spring_data_jpa.repositories.CollegeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService{

    private CollegeRepository repository;

    public CollegeServiceImpl(CollegeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<College> getAllColleges() {
        return repository.findAll();
    }

    @Override
    public College addCollege(College college) {
        return repository.save(college);
    }
}
