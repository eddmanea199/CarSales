package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.Contact;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	//Return list of contacts
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	//Save new contact
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
	
	//Get by id
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}

	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}
	
}
