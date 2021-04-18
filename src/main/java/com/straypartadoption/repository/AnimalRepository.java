package com.straypartadoption.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.straypartadoption.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
	@Query("SELECT a FROM Animal a WHERE a.id = ?1")
	Optional<Animal> findById(Long animalId);
}
