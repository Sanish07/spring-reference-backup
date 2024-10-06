package com.jdbc_intro.dao;


import com.jdbc_intro.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt(1)); //Get column 1 value 'id' which is of type int from resultset
        student.setName(rs.getString(2)); //Get column 2 value 'name' which is of type String from resultset
        student.setCity(rs.getString(3)); ////Get column 3 value 'city' which is of type String from resultset
        return student;
    }
}
