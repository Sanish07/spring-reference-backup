package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.EmployeeDto;
import com.sanish.spring_dto_pattern.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmpById(int id);

    List<Employee> getAllEmp();

    Employee addNewEmployee(EmployeeDto employeeDto);
}
