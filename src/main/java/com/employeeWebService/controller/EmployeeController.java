package com.employeeWebService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employeeWebService.model.Employee;
import com.employeeWebService.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private Employee employee;//Make it correct

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Employee> getAllEmployee() {

		return employee.convertEmployeeEntityListToModelList(employeeService.getAllEmployee());

	}

	@RequestMapping(path = "/getByEmployeeCode/{code}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getByEmployeeCode(@PathVariable("code") int code) {

		return employee.convertEmployeeEntityToModel(employeeService.getByEmployeeCode(code));

	}

	@PostMapping("/addEmployee") //employee 
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee.convertEmployeeModelToEntity(employee));
		
	}
}
