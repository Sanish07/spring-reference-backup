package com.sanish.spring_data_jpa_demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //Will help us to create a builder pattern for the class for properties initialization
@Entity
@Table(name = "author_tbl")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "author_email", unique = true)
    private String email;


    @JsonManagedReference
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<Course> courses;

//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "author_sequence")
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 5)



//    @Column(name = "created_at", updatable = false, nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "last_modified", insertable = false)
//    private LocalDateTime lastModified;
}
