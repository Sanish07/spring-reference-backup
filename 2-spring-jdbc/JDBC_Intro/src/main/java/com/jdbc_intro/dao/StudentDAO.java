package com.jdbc_intro.dao;

import com.jdbc_intro.entities.Student;

import java.util.List;

public interface StudentDAO {
    public int insert(Student student);

    public int updateEntry(Student student);

    public int deleteEntry(int studentId);

    public Student getStudent(int studentId); //Single student fetch

    public List<Student> getAllStudents(); //Get all Students
}
