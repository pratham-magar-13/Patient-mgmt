package com.jackdaw.patient_mgmt.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jackdaw.patient_mgmt.models.Patient;
import com.jackdaw.patient_mgmt.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientController {

	private final PatientService patientService;
	
	public PatientController(PatientService patientService)
	{
		this.patientService=patientService;
	}
	
	@GetMapping
	public ResponseEntity<List<Patient>> getPatients()
	{
		return ResponseEntity.ok().body(patientService.getPatients());
	}
	
	@PostMapping
	public Patient createPatient(@RequestBody Patient patient)
	{
		return patientService.createPatient(patient);
	}
	
	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable UUID id,@RequestBody Patient patient)
	{
		return patientService.updatePatient(id,patient);
	}
}
	