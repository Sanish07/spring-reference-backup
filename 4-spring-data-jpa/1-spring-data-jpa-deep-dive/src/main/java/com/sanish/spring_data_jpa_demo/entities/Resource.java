package com.sanish.spring_data_jpa_demo.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "resource_type")
@Entity
@Table(name = "resource_tbl")
public class Resource{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "resource_name")
    private String name;

    @Column(name = "resource_size")
    private Integer size;

    @Column(name = "resource_url")
    private String url;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
