package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.Client;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	//Return list of clients
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	//Save new client
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	//Get by id
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}

	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}

}
