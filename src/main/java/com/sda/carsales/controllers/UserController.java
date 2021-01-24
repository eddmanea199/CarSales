package com.sda.carsales.controllers;

import com.sda.carsales.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sda.carsales.services.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}



	@GetMapping("/users")
	public String getCountries() {
		return "User";
	}
	
	
	//Modified method to Add a new user User
	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		
		userService.save(user);	
		
		RedirectView  redirectView= new RedirectView("/login",true);
		
	    redir.addFlashAttribute("message",	"You successfully registered! You can now login");
	        
	    return redirectView;				
	}
	
}
