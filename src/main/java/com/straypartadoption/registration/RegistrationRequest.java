package com.straypartadoption.registration;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class RegistrationRequest {
	
	@NotEmpty(message = "First name can not be empty")
    private String firstName;
	
	@NotEmpty(message = "Last name can not be empty")
    private String lastName;
	
	@NotEmpty(message = "Email can not be empty")
	@Email(message = "Provide a valid email")
    private String email;
    
    @NotEmpty(message = "Password can not be empty")
    private String password;
    
	/*
	 * public RegistrationRequest(String firstName, String lastName, String email,
	 * String password) { super(); this.firstName = firstName; this.lastName =
	 * lastName; this.email = email; this.password = password; }
	 */

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistrationRequest [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
