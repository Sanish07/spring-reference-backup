package com.sanish.spring_data_jpa_demo.repositories;

import com.sanish.spring_data_jpa_demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
    //equivalent to : select * from author_tbl where first_name = 'fname'
    public List<Author> findAllByFirstName(String fname);

    //equivalent to : select * from author_tbl where first_name = 'fNamE'
    public List<Author> findAllByFirstNameIgnoreCase(String fname);

    //equivalent to : select * from author_tbl where first_name like '%Nam%'
    public List<Author> findAllByFirstNameContainingIgnoreCase(String fname);

    //equivalent to : select * from author_tbl where first_name like 'naM%'
    public List<Author> findAllByFirstNameStartsWithIgnoreCase(String fname);

    //equivalent to : select * from author_tbl where first_name like '%naM'
    public List<Author> findAllByFirstNameEndsWithIgnoreCase(String fname);

    //equivalent to : select * from author_tbl where first_name in ('abc','fname','xyz')
    public List<Author> findAllByFirstNameInIgnoreCase(List<String> fnames);
}
