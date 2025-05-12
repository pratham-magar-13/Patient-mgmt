package com.jackdaw.patient_mgmt.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jackdaw.patient_mgmt.models.Patient;
import com.jackdaw.patient_mgmt.services.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/patients")
@Tag(name="Patient", description="API for managing patients")
public class PatientController {

	private final PatientService patientService;
	
	public PatientController(PatientService patientService)
	{
		this.patientService=patientService;
	}
	
	@GetMapping
	@Operation(summary="Get Patients")
	public ResponseEntity<List<Patient>> getPatients()
	{
		return ResponseEntity.ok().body(patientService.getPatients());
	}
	
	@PostMapping
	@Operation(summary="Create a new patient")
	public Patient createPatient(@RequestBody Patient patient)
	{
		return patientService.createPatient(patient);
	}
	
	@PutMapping("/{id}")
	@Operation(summary="Update a patient")
	public Patient updatePatient(@PathVariable UUID id,@RequestBody Patient patient)
	{
		return patientService.updatePatient(id,patient);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary="Delete a patient")
	public ResponseEntity<Void>deletePatient(@PathVariable UUID id)
	{
		patientService.deletePatient(id);
		return ResponseEntity.noContent().build();
	}
}
	