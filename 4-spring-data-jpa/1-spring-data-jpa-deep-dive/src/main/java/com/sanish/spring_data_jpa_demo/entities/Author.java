package com.sanish.spring_data_jpa_demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //Will help us to create a builder pattern for the class for properties initialization
@Entity
@Table(name = "author_tbl")
public class Author {

//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "author_sequence")
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 5)


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", length = 40)
    private String firstName;

    @Column(name = "last_name", length = 40)
    private String lastName;

    @Column(name = "author_email", length = 60, unique = true)
    private String email;

    @Column(name = "author_age")
    private Integer age;

//    @Column(name = "created_at", updatable = false, nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "last_modified", insertable = false)
//    private LocalDateTime lastModified;
}
