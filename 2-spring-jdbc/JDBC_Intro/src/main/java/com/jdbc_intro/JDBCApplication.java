package com.jdbc_intro;

import com.jdbc_intro.configuration.JdbcJavaConfig;
import com.jdbc_intro.dao.StudentDAO;
import com.jdbc_intro.dao.StudentDAOImpl;
import com.jdbc_intro.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCApplication {
    public static void main(String[] args) {
       /* System.out.println("Application is running...");
        ApplicationContext context = new ClassPathXmlApplicationContext("student_jdbc.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        //Insertion
        String query = "insert into student(id,name,city) values(?,?,?)";
        int rowsAffected = template.update(query,103,"Luis","Miami");
        System.out.println("Rows updated : "+rowsAffected); */

        //Initializing IOC Container - Via XML config
//        ApplicationContext context = new ClassPathXmlApplicationContext("student_jdbc.xml");
                             //OR
        //Initializing IOC Container - Via Java Config
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcJavaConfig.class);


        //Getting DAO Implementation Bean from XML
        StudentDAOImpl daoImpl = context.getBean("studentDAOImpl", StudentDAOImpl.class);



        /* Insertion */
//        //Creating new Student Object
//        Student student = new Student();
//        student.setId(106);
//        student.setName("Wayne");
//        student.setCity("Manchester");
//
//        //Calling DAOImpl insert method
//        int rowsAffected = daoImpl.insert(student);
//        System.out.println("Rows affected : "+rowsAffected);

        /* Update */
//        Student student = new Student();
//        student.setId(101);
//        student.setName("Sergio");
//        student.setCity("Madrid");
//
//        int rowsAffected = daoImpl.updateEntry(student);
//        System.out.println("Rows Updated : "+rowsAffected);

        /* Deletion */
//        int rowsAffected = daoImpl.deleteEntry(101);
//        System.out.println("Rows Deleted : "+rowsAffected);

        /* Single Row Selection */
//        Student fetchedStudent = daoImpl.getStudent(102);
//        System.out.println(fetchedStudent);

        /* Multi Row Seletion */
        List<Student> fetchedStudents = daoImpl.getAllStudents();
        for(Student s : fetchedStudents){
            System.out.println("Student{ id="+s.getId()+", name="+s.getName()+", city="+s.getCity()+"}");
        }
    }


}
