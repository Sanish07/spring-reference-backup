package com.sanish.spring_dto_pattern.dto;

import jakarta.validation.constraints.NotEmpty;

public record EmployeeDto(
        @NotEmpty
        String fullName,
        Integer age,
        @NotEmpty
        String role,
        Integer org_id
){
}
