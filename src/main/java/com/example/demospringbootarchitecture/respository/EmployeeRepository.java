package com.example.demospringbootarchitecture.respository;

import com.example.demospringbootarchitecture.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
