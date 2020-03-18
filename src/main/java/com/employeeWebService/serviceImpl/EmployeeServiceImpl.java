package com.employeeWebService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeWebService.entity.Employee;
import com.employeeWebService.repository.EmployeeRepository;
import com.employeeWebService.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void editEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getByEmployeeCode(int code) {
		return employeeRepository.findById(code).get();
		
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

}
