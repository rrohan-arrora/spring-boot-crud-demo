package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	//define field for entity manager
	@Autowired
	private EntityManager entityManager;

	@Override
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

	@Override
	public Employee findOne(int id) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee theEmployee = currentSession.get(Employee.class, id);
		
		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// get the employee: saveOrUpdate methos is depricated
		currentSession.persist(theEmployee);
		
	}

	@Override
	public void deleteOne(int id) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete the employee
		currentSession.remove(id);
	}

}
