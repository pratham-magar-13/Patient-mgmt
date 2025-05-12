package com.jackdaw.patient_mgmt.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.jackdaw.patient_mgmt.models.Patient;
import com.jackdaw.patient_mgmt.repositories.PatientRepository;

@Service
public class PatientService {

	private PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository)
	{
		this.patientRepository=patientRepository;
	}
	
	public List<Patient> getPatients()
	{
		return patientRepository.findAll();
	}
	
	public Patient createPatient(Patient patient)
	{
		return patientRepository.save(patient);
	}
	
	public Patient updatePatient(UUID id,Patient patient)
	{
		//find the patient first
		Patient existingPatient=patientRepository.findById(id).orElseThrow();
		
		//update the fields of existing patient
		existingPatient.setName(patient.getName());
		existingPatient.setAddress(patient.getAddress());
		existingPatient.setDateOfBirth(patient.getDateOfBirth());
		existingPatient.setEmail(patient.getEmail());
		existingPatient.setGender(patient.getGender());
		
		//save the fields and return
		return patientRepository.save(existingPatient);
		
	}
	
	public void deletePatient(UUID id)
	{
		patientRepository.deleteById(id);
	}
}

