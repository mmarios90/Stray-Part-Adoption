package com.straypartadoption.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.straypartadoption.entity.Adoption;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long>{
//	@Query("SELECT a FROM Adoption a WHERE a.userId = ?1")
//	Optional <Adoption> findById(Long userId);
	
	List<Adoption> findByUserId(Long userId);
	
	Adoption findByUserIdAndWeek(Long userId, int week);
	
	Optional<Adoption> findById(Long id);
}
