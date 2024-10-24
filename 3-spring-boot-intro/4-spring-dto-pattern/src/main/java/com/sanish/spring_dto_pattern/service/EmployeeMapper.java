package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.EmployeeDto;
import com.sanish.spring_dto_pattern.entity.Employee;
import com.sanish.spring_dto_pattern.entity.Organization;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee dtoToPojoEmp(EmployeeDto employeeDto){

        if(employeeDto == null) throw new NullPointerException("EmployeeDto cannot be mapped as it is null.");

        Employee employee = new Employee();
        employee.setFullName(employeeDto.fullName());
        employee.setAge(employeeDto.age());
        employee.setRole(employeeDto.role());

        Organization organization = new Organization(); //Setting organization object with DTO,
        // only needs an org_id from request to link an employee with an organization
        organization.setId(employeeDto.org_id());

        employee.setOrganization(organization);

        return employee;
    }
}
