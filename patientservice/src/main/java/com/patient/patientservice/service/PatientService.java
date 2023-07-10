package com.patient.patientservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.patient.patientservice.dto.PatientDTO;
import com.patient.patientservice.entities.PatientEntity;
import com.patient.patientservice.exception.PatientServiceException;

public interface PatientService {

	ResponseEntity<String> addPatientToDB(PatientDTO patientDTO);

	List<PatientEntity> getAllPatient();

	PatientEntity getPatientById(int patientId) throws PatientServiceException;

	PatientDTO updatePatientByID(int patientId, PatientEntity patientEntity);
	
	void deletePatientById(int patientId);

}
