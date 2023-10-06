package com.example.demospringbootarchitecture.service.impl;

import com.example.demospringbootarchitecture.model.Employee;
import com.example.demospringbootarchitecture.respository.EmployeeRepository;
import com.example.demospringbootarchitecture.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
