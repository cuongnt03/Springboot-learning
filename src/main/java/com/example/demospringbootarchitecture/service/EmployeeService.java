package com.example.demospringbootarchitecture.service;

import com.example.demospringbootarchitecture.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee findEmployee(long id);
}
