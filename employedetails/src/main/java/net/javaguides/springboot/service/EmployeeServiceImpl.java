package net.javaguides.springboot.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	
	
	

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
		 
		 
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public void findage(Employee employe) {
		
		try {
			 
			 String dob2 = employe.getDob();
			 LocalDate date = LocalDate.parse(dob2);
			  int year = date.getYear();
		
		    employe.setAge(2023-year);
				
		} catch (Exception  e) {
		
			
		System.out.println("Exception rised");
		}  
		
		
		   
	}

	
}
