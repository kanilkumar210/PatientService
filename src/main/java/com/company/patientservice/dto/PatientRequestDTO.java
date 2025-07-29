package com.company.patientservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PatientRequestDTO {

	@NotBlank(message = "name should not be empty")
	private String name;

	@NotBlank(message = "dateOfBirth should not be empty")
	private String dateOfBirth;

	@NotBlank(message = "registrationDate should not be empty")
	private String registrationDate;

	@Email
	@NotBlank(message = "registrationDate should not be empty")
	@Column(unique = true)
	private String email;

	@NotNull(message = "address should not be empty")
	private String address;

	public PatientRequestDTO(@NotNull(message = "name should not be empty") String name,
			@NotNull(message = "dateOfBirth should not be empty") String dateOfBirth,
			@NotNull(message = "registrationDate should not be empty") String registrationDate,
			@Email @NotNull(message = "registrationDate should not be empty") String email,
			@NotNull(message = "address should not be empty") String address) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.email = email;
		this.address = address;
	}

	public PatientRequestDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
