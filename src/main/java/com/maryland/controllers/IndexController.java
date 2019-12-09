package com.maryland.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maryland.models.Employee;

import lombok.extern.log4j.Log4j;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndexController {
	
	Logger log=LoggerFactory.getLogger(IndexController.class);

	
	@Autowired
	Employee employee;
	
	@GetMapping(value = "/employee/{employeeId}")
	public ResponseEntity<Employee> login(@PathVariable Integer employeeId){
		log.info("Invoked login method");;
		employee.setName("rishu");
		employee.setAge(30);
		employee.setCompany("Amazon");
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PostMapping(value="/signup")
	public ResponseEntity<Employee> signup(@RequestBody Employee employee){
		System.out.println(employee.getName());
		System.out.println("posted data ");
		employee.setName("some random name");
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		
		
	}

}
