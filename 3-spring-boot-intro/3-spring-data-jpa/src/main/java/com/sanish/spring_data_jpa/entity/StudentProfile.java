package com.sanish.spring_data_jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_bio")
    private String bio;

    @OneToOne
    @JoinColumn(name = "student_id", unique = true) //Foreign Key will be created with name student_id
    private Student student; //Mapping with Student table/entity - StudentProfile is Secondary/Child Entity

    public StudentProfile() {
    }

    public StudentProfile(String bio) {
        super();
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentProfile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }
}
