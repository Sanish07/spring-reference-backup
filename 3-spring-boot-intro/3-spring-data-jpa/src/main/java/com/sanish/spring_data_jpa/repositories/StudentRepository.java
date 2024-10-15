package com.sanish.spring_data_jpa.repositories;

import com.sanish.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    List<Student> findAllByFirstNameIgnoreCase(String first_name); //Custom search method with Spring JPA Query Methods.
    // We can also use supported keywords inside method names to perform condition based searches.
}
