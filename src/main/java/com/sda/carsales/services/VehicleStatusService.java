package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.VehicleStatus;

@Service
public class VehicleStatusService {
	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	//Return list of countries
	public List<VehicleStatus> getVehicleStatuses(){
		return vehicleStatusRepository.findAll();
	}
	
	//SAve new VehicleStatus
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}
	
	//get by id
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleStatusRepository.deleteById(id);
	}

}
