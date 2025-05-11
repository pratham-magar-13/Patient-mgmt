package com.jackdaw.patient_mgmt.models;


import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String address;
	
	@NotNull
	private LocalDate dateOfBirth;
	
	private String gender;
	
	@NotNull
	private LocalDate registeredDate;
}