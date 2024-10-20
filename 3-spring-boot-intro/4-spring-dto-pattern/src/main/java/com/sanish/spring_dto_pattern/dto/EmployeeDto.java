package com.sanish.spring_dto_pattern.dto;

public record EmployeeDto(
        String fullName,
        int age,
        String role,
        int org_id
){
}
