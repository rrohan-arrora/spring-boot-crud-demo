package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService eService;
	
	//quick and dirty: inject employee dao directly
	@Autowired
	public EmployeeRestController(EmployeeService eService) {
		this.eService = eService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return eService.findAll();
	}
	
	//expose "/employees/{employeeId}" and return list of employees
	@GetMapping("/employees/{employeeId}")
	public Employee findOne(@PathVariable int employeeId){
		Employee theEmployee = eService.findOne(employeeId);
		
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
		
	//expose "/employees/{theEmployeeId}" and return list of employees
	@PostMapping("/employees")
	public void save(@RequestBody Employee theEmployee ){
		
		// just in case, user pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		eService.save(theEmployee);
	}
}
