package com.sanish.spring_data_jpa.services;

import com.sanish.spring_data_jpa.entity.Student;
import com.sanish.spring_data_jpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Student saveStudent(Student student){
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student findStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findStudentsByFirstName(String firstName) {
        return repository.findAllByFirstNameIgnoreCase(firstName);
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}
