package com.straypartadoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.straypartadoption.entity.Animal;
import com.straypartadoption.service.AnimalService;
import com.straypartadoption.service.UserService;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	AnimalService animalService;

	@GetMapping
	public String userAdminGreet() {
		return "Hi Master!";
	}

	@GetMapping("/users")
	public String showUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/adoptions")
	public String showAdoption() {
		return userService.getAllAdoptions();
	}

	//
	@DeleteMapping("/users/delete/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteThisUser(id);
	}

	@DeleteMapping("/adoptions/delete/{id}")
	public void deleteAdoption(@PathVariable("id") Long id) {
		userService.deleteAdoptionByAdmin(id);
	}
	
	@PostMapping("/animal/add")
	public void addAnimal(@RequestBody Animal animal) {
		animalService.addAnimal(animal);
	}
	
	@DeleteMapping("/animal/delete/{id}")
	public void deleteAnimal(@PathVariable("id") Long id) {
		animalService.deleteAnimal(id);
	}
}
