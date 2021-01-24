package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.VehicleMovement;

@Service
public class VehicleMovementService {

	
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	//Return list of vehicleMovements
	public List<VehicleMovement> getVehicleMovements(){
		return vehicleMovementRepository.findAll();
	}
	
	//Save new vehicleMovement
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	//Get by id
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}

}
