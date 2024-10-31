package com.sanish.spring_data_jpa_demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lecture_tbl")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lecture_name")
    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @JsonManagedReference
    @OneToOne(mappedBy = "lecture", cascade = CascadeType.ALL)
    private Resource resource;
}
