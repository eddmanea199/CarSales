package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.Country;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	//Return list of countries
	public List<Country> getCountries(){
		return countryRepository.findAll();
	}
	
	//Save new country
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	//Get by id
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}

	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}
	
}
