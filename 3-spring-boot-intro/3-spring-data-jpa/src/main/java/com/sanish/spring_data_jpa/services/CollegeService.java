package com.sanish.spring_data_jpa.services;

import com.sanish.spring_data_jpa.entity.College;

import java.util.List;

public interface CollegeService {

    List<College> getAllColleges();

    College addCollege(College college);
}
