package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.VehicleHire;

@Service
public class VehicleHireService {
	
	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	//Return list of Vehicle Hire
	public List<VehicleHire> getVehicleHires(){
		return vehicleHireRepository.findAll();
	}
	
	//Save new VehicleHire
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	//Get by id
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleHireRepository.deleteById(id);
	}


}
