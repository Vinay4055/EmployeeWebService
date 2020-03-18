package com.employeeWebService.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
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
	@NotNull
	@Temporal(TemporalType.DATE)
	Date dateOfBirth;
}
