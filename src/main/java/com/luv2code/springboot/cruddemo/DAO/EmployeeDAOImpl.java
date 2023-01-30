package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	//define field for entity manager
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get the result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

}
