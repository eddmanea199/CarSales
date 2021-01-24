package com.sda.carsales.controllers;

import java.util.Optional;

import com.sda.carsales.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sda.carsales.services.SupplierService;
import com.sda.carsales.services.CountryService;
import com.sda.carsales.services.StateService;

@Controller
public class SupplierController {


	private SupplierService supplierService;
	private CountryService countryService;
	private StateService stateService;

	@Autowired
	public SupplierController(SupplierService supplierService, CountryService countryService, StateService stateService) {
		this.supplierService = supplierService;
		this.countryService = countryService;
		this.stateService = stateService;
	}

	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {		
		model.addAttribute("suppliers", supplierService.getSuppliers());	
		
		model.addAttribute("countries", countryService.getCountries());
		
		model.addAttribute("states", stateService.getStates());

		
		return "Supplier";
	}	
	
	@PostMapping("/suppliers/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping("suppliers/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id) {
	  return supplierService.findById(id);	
	}	
	
	@RequestMapping(value="/suppliers/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value="/suppliers/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		supplierService.delete(id);
		return "redirect:/suppliers";
	}
	
}
