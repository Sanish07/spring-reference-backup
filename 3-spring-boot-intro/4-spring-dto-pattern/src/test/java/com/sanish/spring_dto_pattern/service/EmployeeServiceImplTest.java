package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.dto.EmployeeDto;
import com.sanish.spring_dto_pattern.entity.Employee;
import com.sanish.spring_dto_pattern.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest { //We will test this class such that test isolation
    // is achieved, we will use Mockito framework for mocking the dependencies/beans required
    // by EmployeeServiceImpl class

    //Instantiate test class object
    @InjectMocks //Injecting qualifying dependencies(opened for mocking) into test class object
    private EmployeeServiceImpl employeeService;


    //Declaring the dependencies
    @Mock //We are telling Spring to make this object open for mocking
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); //Opening current class dependencies for mocks
    }

    @Test
    public void addNewEmployee_method_should_save_an_employee_to_db(){
        //Expected Param Obj
        EmployeeDto employeeDto = new EmployeeDto("John Hopkins",
                35, "Software Dev",1);

        //Expected object in 1st line of method
        Employee employeePojo = new Employee("John Hopkins",
                35, "Software Dev");

        //Expected saved object(Also the return type, returned to caller) in 2nd line
        Employee savedEmployee = new Employee("John Hopkins",
                35, "Software Dev");
        savedEmployee.setId(101);


        //Mocking all the calls of every step which have external bean/dependencies associated
        Mockito.when(employeeMapper.dtoToPojoEmp(employeeDto))
                .thenReturn(employeePojo); //1st line mock in addNewEmployee method

        Mockito.when(employeeRepository.save(employeePojo))
                .thenReturn(savedEmployee); //2nd line


        //Calling the method we are testing
        Employee savedEmployeeInDatabase = employeeService.addNewEmployee(employeeDto);
        assertEquals(employeeDto.fullName(),savedEmployeeInDatabase.getFullName());
        assertEquals(101, savedEmployeeInDatabase.getId()); //101 is because in mocking we are returning savedEmployee id as 1 when save() method of repository is called
        assertEquals(employeeDto.age(),savedEmployeeInDatabase.getAge());
        assertEquals(employeeDto.role(),savedEmployeeInDatabase.getRole());

        //Ensuring that the internal method calls in method were called only one time.
        Mockito.verify(employeeMapper,Mockito.times(1))
                .dtoToPojoEmp(employeeDto); //1st line verification

        Mockito.verify(employeeRepository,Mockito.times(1))
                .save(employeePojo); //2nd line verification
    }

    @Test
    public void getEmpById_should_return_an_employee_of_corresponding_id(){
        int employee_id = 105; //Expected Param

        Employee fetchedEmployee = new Employee("Alex Massey",29,"Analyst");
        fetchedEmployee.setId(105); //Expected Employee object fetch from database

        //Mocking calls
        Mockito.when(employeeRepository.findById(employee_id))
                .thenReturn(Optional.of(fetchedEmployee));

        Employee returnedEmployee = employeeService.getEmpById(employee_id);

        assertEquals(employee_id, returnedEmployee.getId());
        assertEquals("Alex Massey", returnedEmployee.getFullName());
        assertEquals(29, returnedEmployee.getAge());
        assertEquals("Analyst", returnedEmployee.getRole());

        //Verifying method call frequency
        Mockito.verify(employeeRepository,Mockito.times(1))
                .findById(employee_id);

    }
}