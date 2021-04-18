package com.straypartadoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.straypartadoption.entity.User;
import com.straypartadoption.service.AdoptionService;
import com.straypartadoption.service.AnimalService;
import com.straypartadoption.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	AnimalService animalService;
	@Autowired
	UserService userService;
	@Autowired
	AdoptionService adoptionService;
	
	
	@GetMapping
	public String userAccountGreet() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "Welcome " + user.getFirstName() + "!";
	}
	
	@GetMapping("/strays")
	//public List<Animal> showAnimals() {
	public String showAnimals() {	
		System.out.println("List of strays for adoption");
		return animalService.getAllAnimals().toString();
	}
	
	
	@GetMapping("/adoptions")
	//public List<Adoption> showMyadoptions(){
	public String showMyadoptions(){
		return userService.getUserAdoptions().toString();
	}
	
	@GetMapping("/add/{id}/{week}") 
	public void setAdoption(@PathVariable("id") Long id, @PathVariable("week") Integer week) {
		userService.addThisAdoption(id, week);
	}
	
	@GetMapping("/delete/{id}/{week}")
	//@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public void deleteAdoption(@PathVariable("id") Long id, @PathVariable("week") Integer week){
		userService.deleteThisAdoption(id, week);
	}
	
}
