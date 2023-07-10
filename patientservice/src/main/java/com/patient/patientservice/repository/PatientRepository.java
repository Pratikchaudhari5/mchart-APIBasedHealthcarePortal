package com.patient.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.patient.patientservice.entities.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
	// from java 1.8 static and default methods are allowed in Interface, Why?
	// before java 1.8 only abstract methods are allowed in Interface

}
