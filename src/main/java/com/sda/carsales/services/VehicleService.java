package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.models.Employee;
import com.sda.carsales.models.Vehicle;
import com.sda.carsales.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//Return list of vehicles
	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
	}
	
	//Save new vehicle
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	//Get by id
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
	}


}
