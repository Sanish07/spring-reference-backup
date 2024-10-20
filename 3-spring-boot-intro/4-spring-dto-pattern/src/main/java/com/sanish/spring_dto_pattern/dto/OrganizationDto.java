package com.sanish.spring_dto_pattern.dto;

public record OrganizationDto(
        String name,
        String description
) {
    //A record will auto-generate no-arg + all-args constructors,
    // getters and setters, equals(), hashCode(), and toString() methods
}
