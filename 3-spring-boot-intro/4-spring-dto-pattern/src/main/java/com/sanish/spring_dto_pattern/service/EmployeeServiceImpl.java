package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.EmployeeDto;
import com.sanish.spring_dto_pattern.entity.Employee;
import com.sanish.spring_dto_pattern.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee getEmpById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee addNewEmployee(EmployeeDto employeeDto) {
        Employee employeePojo = employeeMapper.dtoToPojoEmp(employeeDto);
        return employeeRepository.save(employeePojo);
    }
}
