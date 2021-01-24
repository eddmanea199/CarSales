package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.VehicleModel;

@Service
public class VehicleModelService {
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	//Return list of countries
	public List<VehicleModel> getVehicleModels(){
		return vehicleModelRepository.findAll();
	}
	
	//Save new VehicleModel
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
	//Get by id
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleModelRepository.deleteById(id);
	}

}
