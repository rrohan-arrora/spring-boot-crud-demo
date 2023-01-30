package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.daoSpringDataJPA.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImplSpringDataJPA implements EmployeeService {
	
	private EmployeeRepository eRepo;

	@Autowired
	public EmployeeServiceImplSpringDataJPA(EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}
	
	@Override
	public List<Employee> findAll() {
		return eRepo.findAll();		
	}

	@Override
	public void save(Employee theEmployee) {
		eRepo.save(theEmployee);
		
	}

	@Override
	public void deleteOne(int id) {
		eRepo.deleteById(id);
		
	}

	@Override
	public Employee findOne(int id) {
		
		Optional<Employee> result = eRepo.findById(id);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return theEmployee;
	}

}
