package com.sda.carsales.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sda.carsales.models.Contact;
import com.sda.carsales.services.ContactService;
import com.sda.carsales.services.CountryService;
import com.sda.carsales.services.StateService;

@Controller
public class ContactController {
	
	private ContactService contactService;
	private CountryService countryService;
	private StateService stateService;

	@Autowired
	public ContactController(ContactService contactService, CountryService countryService, StateService stateService) {
		this.contactService = contactService;
		this.countryService = countryService;
		this.stateService = stateService;
	}

	@GetMapping("/contacts")
	public String getContacts(Model model) {		
		model.addAttribute("contacts", contactService.getContacts());	
		
		model.addAttribute("countries", countryService.getCountries());
		
		model.addAttribute("states", stateService.getStates());

		
		return "Contact";
	}	
	
	@PostMapping("/contacts/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping("contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(int id) {
	  return contactService.findById(id);	
	}	
	
	@RequestMapping(value="/contacts/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="/contacts/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}

}
