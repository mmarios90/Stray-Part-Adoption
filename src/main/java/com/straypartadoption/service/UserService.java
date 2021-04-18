package com.straypartadoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.straypartadoption.entity.Adoption;
import com.straypartadoption.entity.Animal;
import com.straypartadoption.entity.User;
import com.straypartadoption.repository.AdoptionRepository;
import com.straypartadoption.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	AdoptionRepository adoptionRepository;
		 
	@Autowired
	AnimalService animalService;
	
	@Autowired
	AdoptionService adoptionService;
	
	@Autowired
	UserRepository userRepository;
	
	
	public List<Adoption> getUserAdoptions() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long userId = user.getId();
		return adoptionService.getAdoptions(userId);
	}

	public void addThisAdoption(Long id, Integer week) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Animal animal = animalService.getAnimal(id);
		Long userId = user.getId();
		Integer weekSlot = week-1;

		if (animal.isThisWeekFree(weekSlot) && user.isThisWeekFree(weekSlot)) {
			Adoption adoption = new Adoption(userId, id, weekSlot);
			adoptionService.addAdoption(adoption);

			animal.setAdoptionWeek(weekSlot);
			user.setAdoptionWeek(weekSlot);
		} else {System.out.println("Occupied Week. Please choose a free week for both you and your pet.");}
		
		
		animalService.addAnimal(animal);
		userRepository.save(user);	 
	}
	
	public void deleteThisAdoption(Long id, Integer week) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer weekSlot = week-1;
		
		try {		
			Animal animal = animalService.getAnimal(id);
			Adoption adoption = adoptionService.getAdoption(user.getId(), weekSlot);
		
			adoptionRepository.delete(adoption);
			user.releaseWeek(weekSlot);
			animal.releaseWeek(weekSlot);
			
			animalService.addAnimal(animal);
			userRepository.save(user);
			
		} catch(Exception e) {
			System.out.println("You set wrong values");
		}	
	}
	
	
	
	// ADMIN SERVICE METHODS (incomplete)
		
	public String getAllUsers() {
		return userRepository.findAll().toString(); 
	}
	 
	
	public String getAllAdoptions() {
		return adoptionRepository.findAll().toString();
	}
	
	public void deleteAdoptionByAdmin(Long id) {
		
		Adoption adotpion = adoptionService.getThisAdoption(id);
		Long userId = adotpion.getUserId();
		Long animalId = adotpion.getAnimalId();
		
		User user = userRepository.getOne(userId);
		Animal animal = animalService.getAnimal(animalId);
		
		int week = adotpion.getI();
		user.releaseWeek(week);
		animal.releaseWeek(week);
		
		userRepository.save(user);
		animalService.addAnimal(animal);
		
		adoptionRepository.deleteById(id);
	}
	
	public void deleteThisUser(Long id) { 
		//to do: put logic for affected adoption and animals
		//userRepository.deleteById(id); 
	}
	 
	public void deleteThisAnimal(Long id) {
		//to do: put logic for affected adoption and users
		//animalService.deleteAnimal(id);
	}
	
	
}
