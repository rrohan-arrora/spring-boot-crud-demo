package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	public Employee findOne(int id);
	public void save(Employee theEmployee);
	public void deleteOne(int id);
}
