package com.sda.carsales.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.sda.carsales.models.Employee;
import com.sda.carsales.models.User;
import com.sda.carsales.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sda.carsales.repositories.UserRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

//	@Autowired
//	private UserRepository userRepository;
	
	//Return list of employees
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	//Save new employee
	public void save(Employee employee) { employeeRepository.save(employee);}
	
	//Get by id
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}
	
	//Get employees by keyword
	public List<Employee> findByKeyword(String keyword){
		return employeeRepository.findByKeyword(keyword);
	}

	public Employee findByUsername(String un) {
		return employeeRepository.findByUsername(un);
	}

	//Set the Username of the employee where firstname and lastname match
//	public void assignUsername(int id){
//		Employee employee = employeeRepository.findById(id).orElse(null);
//		User user = userRepository.findByFirstnameAndLastname(
//				employee.getFirstname(),
//				employee.getLastname());
//		employee.setUsername(user.getUsername());
//		employeeRepository.save(employee);}

}
