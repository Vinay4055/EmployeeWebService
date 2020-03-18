package com.employeeWebService.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private Employee employee;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Employee> getAllEmployee() {

		return employee.convertEmployeeEntityListToModelList(employeeService.getAllEmployee());

	}

	@RequestMapping(path = "/getByEmployeeCode/{code}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getByEmployeeCode(@PathVariable("code") int code) {

		return employee.convertEmployeeEntityToModel(employeeService.getByEmployeeCode(code));

	}

	@PutMapping("/editEmployee/{code}/{name}/{location}/{emailId}/{dateOfBirth}")
	public void editEmployee(@PathVariable int code, @PathVariable String name, @PathVariable String location,
			@PathVariable String emailId, @PathVariable String dateOfBirth) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = df.parse(dateOfBirth);
		employee.setCode(code);
		employee.setName(name);
		employee.setLocation(location);
		employee.setEmailId(emailId);
		employee.setDateOfBirth(dob);

		employeeService.editEmployee(employee.convertEmployeeModelToEntity(employee));
	}
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee.convertEmployeeModelToEntity(employee));
		
	}
}
