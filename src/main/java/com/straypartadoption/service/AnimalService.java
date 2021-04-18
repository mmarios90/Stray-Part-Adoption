package com.straypartadoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straypartadoption.entity.Animal;
import com.straypartadoption.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	AnimalRepository animalRepository;
	
	public List<Animal> getAllAnimals(){
		return animalRepository.findAll();
	}
	
	public Animal getAnimal(Long animalId) {
		return animalRepository.getOne(animalId);
	}
	
	public void addAnimal(Animal animal) {
		animalRepository.save(animal);
	}
	 
	public void deleteAnimal(Long animalId) {
		animalRepository.deleteById(animalId);
	}
	
}
