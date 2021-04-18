package com.straypartadoption.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straypartadoption.entity.Adoption;
import com.straypartadoption.repository.AdoptionRepository;

@Service
public class AdoptionService {

	@Autowired
	AdoptionRepository adoptionRepository;
	
	public void addAdoption(Adoption adoption) {
		adoptionRepository.save(adoption);
	}
	
	public List<Adoption> getAdoptions(Long userId){
		return adoptionRepository.findByUserId(userId);
	}
	
	public Adoption getAdoption(Long userId, Integer week) {
		return adoptionRepository.findByUserIdAndWeek(userId, week);
	}
	
	public Adoption getThisAdoption(Long id) {
		Optional<Adoption> adoptiondb =adoptionRepository.findById(id);
		if(adoptiondb.isPresent()) {
			Adoption adoption = adoptiondb.get();
			return adoption;
		} else {
			System.out.println("There is no adoption with this id");
			return null;
		}
	}
	
	public void deleteAdoption(Adoption adoption) {
		adoptionRepository.delete(adoption);
	}
}
