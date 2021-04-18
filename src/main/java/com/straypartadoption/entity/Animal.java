package com.straypartadoption.entity;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.array.BooleanArrayType;

@TypeDef(name = "boolean-array", typeClass = BooleanArrayType.class)
@Entity
@Table(name = "animals")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long animalId;
	private String name;
	private String species;
	private String breed;
	private String colour;
	private String gender;
	private Double weight;
	private LocalDate dateOfBirth;
	
	@Type(type = "boolean-array")
    @Column(name = "animal_week", columnDefinition = "boolean[]")
	private Boolean[] AnimalWeek = new Boolean[4];
	//to do: enhance with atomic boolean values for potential concurrency issues
	
	public Animal(String name, String species, String breed, String colour, String gender, Double weight, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.colour = colour;
		this.gender = gender;
		this.weight = weight;
		this.dateOfBirth = dateOfBirth;
		Arrays.fill(this.AnimalWeek, Boolean.TRUE);
	}
	
	public Animal() {
		super();
	}


	public Long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean[] getAnimalWeek() {
		return AnimalWeek;
	}

	public void setAnimalWeek(Boolean[] animalWeek) {
		AnimalWeek = animalWeek;
	}

	public Boolean isThisWeekFree(int i) {
		return AnimalWeek[i];
	}
	
	public void setAdoptionWeek(int i) {
		AnimalWeek[i] = false;
	}
	
	public void releaseWeek(int i) {
		AnimalWeek[i] = true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [animalId=");
		builder.append(animalId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", species=");
		builder.append(species);
		builder.append(", breed=");
		builder.append(breed);
		builder.append(", colour=");
		builder.append(colour);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", AnimalWeek=");
		builder.append(Arrays.toString(AnimalWeek));
		builder.append("]\n");
		return builder.toString();
	}

}
