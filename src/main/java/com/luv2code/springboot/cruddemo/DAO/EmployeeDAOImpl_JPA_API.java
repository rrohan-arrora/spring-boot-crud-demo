package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class EmployeeDAOImpl_JPA_API implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl_JPA_API(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query theQuery = 
				entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee findOne(int id) {
		
		// get employee
		Employee theEmployee = 
				entityManager.find(Employee.class, id);
		
		// return employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with id from db ... so we can get generated id from save/insert
		//theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteOne(int id) {
		
		Query theQuery = 
				entityManager.createQuery("delete from Employee where id= :id");
		
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
	}

}
