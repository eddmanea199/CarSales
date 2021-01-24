package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.models.Supplier;
import com.sda.carsales.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//Return list of suppliers
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}
	
	//Save new supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	//Get by id
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}

	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}

}
