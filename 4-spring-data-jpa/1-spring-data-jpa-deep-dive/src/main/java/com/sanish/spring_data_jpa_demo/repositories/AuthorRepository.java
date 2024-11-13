package com.sanish.spring_data_jpa_demo.repositories;

import com.sanish.spring_data_jpa_demo.entities.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    //Using named queries - Method name should be same as defined in Entity class
    public List<Author> namedQueryFindByAge(@Param("author_age") Integer age);

    //We need @Modifying and @Transactional anno. even if it is named query
    @Modifying
    @Transactional
    public void namedQuerySetAllModTime(@Param("time") LocalDateTime time);


    //Custom update queries - use @Modifying & @Transactional for CUD opearations

    //Method to update an author's age when his id is known
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    public Integer updateAuthorAge(Integer age, Integer id);

    //Method to update all authors last_modified_at field at once
    @Modifying
    @Transactional
    @Query("update Author a set a.lastModifiedAt = :time")
    public void updateAllAuthorLastModifiedTime(LocalDateTime time);



    //Derived Queries
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
