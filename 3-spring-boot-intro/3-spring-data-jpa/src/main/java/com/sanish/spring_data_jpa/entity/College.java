package com.sanish.spring_data_jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "college_id")
    private int id;

    @Column(name = "college_name")
    private String name;

    @OneToMany(mappedBy = "college")
    private List<Student> students; //Mapping with Student table - College is primary entity

    public College() {
    }

    public College(String name) {
        super();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
