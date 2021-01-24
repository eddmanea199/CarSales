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

import com.sda.carsales.models.VehicleMovement;
import com.sda.carsales.services.LocationService;
import com.sda.carsales.services.VehicleMovementService;
import com.sda.carsales.services.VehicleService;

@Controller
public class VehicleMovementController {


	
	private VehicleMovementService vehicleMovementService;
	private VehicleService vehicleService;
	private LocationService locationService;

	@Autowired
	public VehicleMovementController(VehicleMovementService vehicleMovementService, VehicleService vehicleService, LocationService locationService) {
		this.vehicleMovementService = vehicleMovementService;
		this.vehicleService = vehicleService;
		this.locationService = locationService;
	}

	@GetMapping("/vehicleMovements")
	public String getVehicleMovements(Model model) {		
		model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());	
		
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("locations", locationService.getLocations());
		

		
		return "VehicleMovement";
	}	
	
	@PostMapping("/vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping("vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id) {
	  return vehicleMovementService.findById(id);	
	}	
	
	@RequestMapping(value="/vehicleMovements/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping(value="/vehicleMovements/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	}

}
