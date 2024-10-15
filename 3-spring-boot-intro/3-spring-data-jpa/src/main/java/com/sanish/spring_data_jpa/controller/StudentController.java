package com.sanish.spring_data_jpa.controller;

import com.sanish.spring_data_jpa.entity.Student;
import com.sanish.spring_data_jpa.services.StudentService;
import com.sanish.spring_data_jpa.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String greet(){
        return "Hello developer";
    }

    @PostMapping("/students")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> fetchedStudentList = studentService.getAllStudents();
        return new ResponseEntity<>(fetchedStudentList, HttpStatus.OK);
    }

    @GetMapping("/students/{student-id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("student-id") int id){
        Student fetchedStudent = studentService.findStudentById(id);
        return new ResponseEntity<>(fetchedStudent, HttpStatus.OK);
    }

    @GetMapping("/students/search/{student-first-name}")
    public ResponseEntity<List<Student>> getStudentsByFirstName(
            @PathVariable("student-first-name") String firstName){
        List<Student> searchedStudents = studentService.findStudentsByFirstName(firstName);
        return new ResponseEntity<>(searchedStudents,HttpStatus.OK);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentEntry(@PathVariable("student-id") int id){
        studentService.deleteStudent(id);
    }
}
