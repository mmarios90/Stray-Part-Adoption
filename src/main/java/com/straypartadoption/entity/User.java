package com.straypartadoption.entity;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vladmihalcea.hibernate.type.array.BooleanArrayType;


@TypeDef(name = "boolean-array", typeClass = BooleanArrayType.class)
@Entity
@Table(name = "users")
public class User implements UserDetails{
	
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private  Long id;
	private  String firstName;
	private  String lastName;
	private  String email;
	private  String password;
	@Enumerated(EnumType.STRING)
	private  UserRole role;
	//private  Boolean locked;
	//private Boolean enabled;
	
	@Type(type = "boolean-array")
    @Column(name = "user_week", columnDefinition = "boolean[]")
	private Boolean[] UserWeek = new Boolean[4];
	
	public User( String firstName, String lastName, String email, String password, UserRole role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		Arrays.fill(this.UserWeek, Boolean.TRUE);
	}
	public User() {}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean[] getUserWeek() {
		return UserWeek;
	}
	public void setUserWeek(Boolean[] userWeek) {
		UserWeek = userWeek;
	}
	
	public Boolean isThisWeekFree(int i) {
		return UserWeek[i];
	}
	
	public void setAdoptionWeek(int i) {
		UserWeek[i] = false;
	}
		
	public void releaseWeek(int i) {
		UserWeek[i] = true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", role=");
		builder.append(role);
		builder.append(", UserWeek=");
		builder.append(Arrays.toString(UserWeek));
		builder.append("]");
		return builder.toString();
	}
}