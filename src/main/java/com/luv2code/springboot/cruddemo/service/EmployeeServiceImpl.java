package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	@Qualifier("employeeDAOImpl_JPA_API") // added because of 2 DAO implementations
	private EmployeeDAO employeeDao;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();		
	}

	@Override
	@Transactional
	public Employee findOne(int id) {
		return employeeDao.findOne(id);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteOne(int id) {
		employeeDao.deleteOne(id);
		
	}

}
