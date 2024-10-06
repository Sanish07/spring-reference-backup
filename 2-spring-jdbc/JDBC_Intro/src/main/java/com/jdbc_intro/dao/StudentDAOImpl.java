package com.jdbc_intro.dao;

import com.jdbc_intro.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Student> rowMapper;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Student> getRowMapper() {
        return rowMapper;
    }

    public void setRowMapper(RowMapper<Student> rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        int rowsAffected = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return rowsAffected;
    }

    @Override
    public int updateEntry(Student student) {
        String query = "update student set name=? , city=? where id=?";
        int rowsAffected = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return rowsAffected;
    }

    @Override
    public int deleteEntry(int studentId) {
        String query = "delete from student where id=?";
        int rowsAffected = this.jdbcTemplate.update(query,studentId);
        return rowsAffected;
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id=?";
        Student fetchedStudent = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return fetchedStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from student";
        List<Student> fetchedStudents = this.jdbcTemplate.query(query,rowMapper);
        return fetchedStudents;
    }
}
