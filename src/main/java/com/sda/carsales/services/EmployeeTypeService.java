package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.models.EmployeeType;
import com.sda.carsales.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTypeService {
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//Return list of countries
	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
	}
	
	//Save new EmployeeType
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	//Get by id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
	}

}
