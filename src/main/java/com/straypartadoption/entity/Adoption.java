package com.straypartadoption.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Adoption")
public class Adoption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long userId;
	private Long animalId;
	private int week;
		
	public Adoption() {
		super();
	}

	public Adoption(Long userId, Long animalId, int week) {
		super();
		this.userId = userId;
		this.animalId = animalId;
		this.week = week;
	}

	public int getI() {
		return week;
	}

	public void setI(int week) {
		this.week = week;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//builder.append("Adoption [id=");
		//builder.append(id);
		//builder.append(", userId=");
		//builder.append(userId);
		builder.append("animalId=");
		builder.append(animalId);
		builder.append(", week=");
		builder.append(week+1);
		builder.append("]\n");
		return builder.toString();
	}
}
