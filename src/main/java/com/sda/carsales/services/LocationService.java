package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.Location;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	//Return list of countries
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	//Save new Location
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	//Get by id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}


}
