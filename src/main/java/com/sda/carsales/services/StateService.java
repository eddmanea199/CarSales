package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.State;

@Service
public class StateService {
	
	
	@Autowired
	private StateRepository stateRepository;
	
	//Return list of states
	public List<State> getStates(){
		return stateRepository.findAll();
	}
	
	//Save new state
	public void save(State state) {
		stateRepository.save(state);
	}
	
	//Get by id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}

	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}
	
	
}
