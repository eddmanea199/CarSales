package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.VehicleMake;

@Service
public class VehicleMakeService {
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	//Return list of countries
	public List<VehicleMake> getVehicleMakes(){
		return vehicleMakeRepository.findAll();
	}
	
	//Save new VehicleMake
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	//Get by id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}

}
