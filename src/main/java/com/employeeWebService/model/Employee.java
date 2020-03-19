package com.employeeWebService.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Employee {
	@NotNull(message = "Emp Code can not be null")
	int code;
	@NotEmpty(message = "Name can not be null")
	@Size(max = 100, message = "Name can not be 100 characters long")
	String name;
	@NotNull
	@Size(max = 500, message = "location can not be 500 characters long")
	String location;
	@NotNull
	@Size(max = 100, message = "EmailId can not be 100 characters long")
	String emailId;
	Date dateOfBirth;
	@NotNull
	String dobInString;
	public String getDobInString() {
		return dobInString;
	}
	
	public void setDobInString(String dobInString) throws ParseException {
		this.dobInString = dobInString;
		if(dobInString != null)
		this.dateOfBirth= new SimpleDateFormat("yyyy-MM-dd").parse(dobInString);
		
			
	}

	public Employee convertEmployeeEntityToModel(com.employeeWebService.entity.Employee source) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(source, com.employeeWebService.model.Employee.class);

	}
	
	public com.employeeWebService.entity.Employee convertEmployeeModelToEntity(Employee source) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(source, com.employeeWebService.entity.Employee.class);

	}


	public List<Employee> convertEmployeeEntityListToModelList(List<com.employeeWebService.entity.Employee> source) {
		List<Employee> convertedList = new ArrayList<>();

		for (int i = 0; i < source.size(); i++) {
			com.employeeWebService.entity.Employee employeeEntity = source.get(i);

			Employee employeeModel = convertEmployeeEntityToModel(employeeEntity);

			convertedList.add(employeeModel);

		}
		return convertedList;
	}
}
