package com.sanish.spring_data_jpa_demo.repositories;

import com.sanish.spring_data_jpa_demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
