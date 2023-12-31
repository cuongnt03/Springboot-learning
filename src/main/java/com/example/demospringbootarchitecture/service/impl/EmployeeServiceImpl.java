package com.example.demospringbootarchitecture.service.impl;

import com.example.demospringbootarchitecture.exception.ResourceNotFoundException;
import com.example.demospringbootarchitecture.model.Employee;
import com.example.demospringbootarchitecture.respository.EmployeeRepository;
import com.example.demospringbootarchitecture.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(long id) {
        // cach 1
//        Optional<Employee> employee = employeeRepository.findById(id);
////        if (employee.isPresent())
////            return employee.get();
////        else
////            throw new ResourceNotFoundException("Employee", "ID", id);
        // cach 2
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // check id exist in database or not
        Employee exsistingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "ID", id));

        exsistingEmployee.setFirstName(employee.getFirstName());
        exsistingEmployee.setLastName(employee.getLastName());
        exsistingEmployee.setEmail(employee.getEmail());

        //save existing employee to database
        employeeRepository.save(exsistingEmployee);

        return exsistingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        // check wether a employee is existed or not
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));

        employeeRepository.deleteById(id);
    }
}
