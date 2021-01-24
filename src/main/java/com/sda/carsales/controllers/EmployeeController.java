package com.sda.carsales.controllers;

import java.util.Optional;

import com.sda.carsales.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sda.carsales.services.CountryService;
import com.sda.carsales.services.EmployeeService;
import com.sda.carsales.services.EmployeeTypeService;
import com.sda.carsales.services.JobTitleService;
import com.sda.carsales.services.StateService;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;
	private JobTitleService jobTitleService;
	private EmployeeTypeService employeeTypeService;
	private CountryService countryService;
	private StateService stateService;

    @Autowired
	public EmployeeController(EmployeeService employeeService, JobTitleService jobTitleService, EmployeeTypeService employeeTypeService, CountryService countryService, StateService stateService) {
		this.employeeService = employeeService;
		this.jobTitleService = jobTitleService;
		this.employeeTypeService = employeeTypeService;
		this.countryService = countryService;
		this.stateService = stateService;
	}

	@GetMapping("/employees")
	public String getEmployees(Model model, String keyword) {	
		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());		
	    model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());			
		model.addAttribute("states", stateService.getStates());		

		if(keyword != null){
			model.addAttribute("employees", employeeService.findByKeyword(keyword));
		}
		else 
		{
		     model.addAttribute("employees", employeeService.getEmployees());
		}
		
		return "Employee";
	}	
	
	@GetMapping("/employeesFiltered")
	public String getEmployeesFiltered(Model model, String keyword) {	
		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());		
	    model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());			
		model.addAttribute("states", stateService.getStates());		

	   model.addAttribute("employees", employeeService.getEmployees());			

		
		return "EmployeeFiltered";
	}
	
	
	
	@PostMapping("/employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping("employees/findById")
	@ResponseBody
	public Optional<Employee> findById(int id) {
	  return employeeService.findById(id);	
	}	
	
	@RequestMapping(value="/employees/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping(value="/employees/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}

//	//Assign Employee Username
//	@RequestMapping(value = "/employees/assignUsername")
//	public  String assignUsername(int id){
//		employeeService.assignUsername(id);
//		return "redirect:/employees";
//	}
	

}
