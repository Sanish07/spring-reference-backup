package com.sanish.spring_data_jpa_demo.repositories;

import com.sanish.spring_data_jpa_demo.entities.resource_types.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Integer> {
}
