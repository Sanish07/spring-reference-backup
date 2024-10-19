package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.entity.Employee;
import com.sanish.spring_dto_pattern.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
