package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.EmployeeDto;
import com.sanish.spring_dto_pattern.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    private EmployeeMapper employeeMapper;

    @BeforeEach
    void setUp(){
        employeeMapper = new EmployeeMapper();
    }

    @Test
    public void dtoToPojoEmp_should_throw_exception_if_dto_is_null(){
        var exception = assertThrows(NullPointerException.class, () -> employeeMapper.dtoToPojoEmp(null));
        assertEquals("EmployeeDto cannot be mapped as it is null.",exception.getMessage());
    }

    @Test
    public void shouldMapEmployeeDtoToPojo(){
        EmployeeDto employeeDto = new EmployeeDto("Sanish",23,
                "Software Dev",2);

        Employee employee = employeeMapper.dtoToPojoEmp(employeeDto);

        assertEquals(employeeDto.fullName(),employee.getFullName());
        assertEquals(employeeDto.age(),employee.getAge());
        assertEquals(employeeDto.role(),employee.getRole());
        assertNotNull(employee.getOrganization());
        assertEquals(employeeDto.org_id(),employee.getOrganization().getId());
    }
}