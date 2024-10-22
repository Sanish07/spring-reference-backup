package com.sanish.spring_dto_pattern.dto;

import jakarta.validation.constraints.NotEmpty;

public record OrganizationDto(
        @NotEmpty(message = "Org. Name should not be empty.")
        String name,
        @NotEmpty(message = "Org. description should not be empty.")
        String description
) {
    //A record will auto-generate no-arg + all-args constructors,
    // getters and setters, equals(), hashCode(), and toString() methods
}
