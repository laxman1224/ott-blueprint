package com.soct.ott.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationDto {

	@NotNull(message = "Firstname cannot be empty")
	@Size(min = 2, max = 50, message = "Firstname must be greater than 2 characters")
	private String firstName;

	@NotNull(message = "Lastname cannot be empty")
	@Size(min = 2, max = 50, message = "Lastname must be greater than 2 characters")
	private String lastName;

	@NotNull(message = "Password cannot be empty")
	@Size(min = 4, max = 8, message = "Password must be equal or greater than 4 characters and less than 8 characters")
	private String password;

	@NotNull(message = "Email cannot be empty")
	@Email
	@Size(max = 100, message = "email should not exceed 100 characters")
	private String email;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
