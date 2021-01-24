package com.sda.carsales.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sda.carsales.models.Country;
import com.sda.carsales.services.CountryService;

@Controller
public class CountryController {

	private CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping("/countries")
	public String getCountries(Model model) {		
		List<Country> countryList = countryService.getCountries();	
		model.addAttribute("countries", countryList);	
		return "country";
	}	
	
	@PostMapping("/countries/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping("countries/findById")
	@ResponseBody
	public Optional<Country> findById(int id) {
	  return countryService.findById(id);	
	}	
	
	@RequestMapping(value="/countries/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping(value="/countries/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}
	
}
