package com.employeeWebService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeWebService.entity.Employee;
@Service
public interface EmployeeService {



public List<Employee> getAllEmployee();

public Employee getByEmployeeCode(int code);

public void addEmployee(Employee employee);


}
