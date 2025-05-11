package com.jackdaw.patient_mgmt.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jackdaw.patient_mgmt.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, UUID>{

	
}
