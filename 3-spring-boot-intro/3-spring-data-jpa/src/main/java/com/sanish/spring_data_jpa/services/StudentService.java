package com.sanish.spring_data_jpa.services;

import com.sanish.spring_data_jpa.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student findStudentById(int id);

    List<Student> findStudentsByFirstName(String firstName);

    void deleteStudent(int id);
}
