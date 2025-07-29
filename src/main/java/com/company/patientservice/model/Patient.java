package com.company.patientservice.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "name should not be empty")
	private String name;

	@NotNull(message = "dateOfBirth should not be empty")
	private LocalDate dateOfBirth;

	@NotNull(message = "registrationDate should not be empty")
	private LocalDate registrationDate;

	@Email
	@NotNull(message = "registrationDate should not be empty")
	@Column(unique = true)
	private String email;

	@NotNull(message = "address should not be empty")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
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

	public Patient(int id, @NotNull(message = "name should not be empty") String name,
			@NotNull(message = "dateOfBirth should not be empty") LocalDate dateOfBirth,
			@NotNull(message = "registrationDate should not be empty") LocalDate registrationDate,
			@Email @NotNull(message = "registrationDate should not be empty") String email,
			@NotNull(message = "address should not be empty") String address) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.email = email;
		this.address = address;
	}

	public Patient() {
		super();
	}

}
