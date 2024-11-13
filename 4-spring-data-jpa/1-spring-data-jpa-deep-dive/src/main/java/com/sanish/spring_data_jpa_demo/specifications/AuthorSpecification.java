package com.sanish.spring_data_jpa_demo.specifications;

import com.sanish.spring_data_jpa_demo.entities.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    //Will help us to create a filter query for age field
    public static Specification<Author> hasAge(Integer age){
        return (
                Root<Author> root,
                CriteriaQuery<?> criteriaQuery,
                CriteriaBuilder criteriaBuilder
                ) -> {
            if(age < 0) return null;
            return criteriaBuilder.equal(root.get("age"), age); //.get() has param name same as Entity field name
        };
    }

    //Creates a filter query for finding a substring in firstName
    public static Specification<Author> firstNameLike(String fname){
        return (
                Root<Author> root,
                CriteriaQuery<?> criteriaQuery,
                CriteriaBuilder criteriaBuilder
                ) -> {
            if(fname == null) return null;
            return criteriaBuilder.like(root.get("firstName"), "%"+fname+"%");
        };


    }
}
