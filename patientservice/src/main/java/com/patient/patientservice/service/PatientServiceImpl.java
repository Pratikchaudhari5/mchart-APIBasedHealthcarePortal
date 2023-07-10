package com.patient.patientservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patient.patientservice.dto.PatientDTO;
import com.patient.patientservice.entities.PatientEntity;
import com.patient.patientservice.exception.PatientServiceException;
import com.patient.patientservice.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	// service layer

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public ResponseEntity<String> addPatientToDB(PatientDTO patientDTO) {

		PatientEntity patientEntity = new PatientEntity();

		patientEntity.setPatientAge(patientDTO.getPatientAge());
		patientEntity.setPatientDisease(patientDTO.getPatientDisease());
		patientEntity.setPatientDOB(patientDTO.getPatientDOB());
		patientEntity.setPatientName(patientDTO.getPatientName());

		patientRepo.saveAndFlush(patientEntity);

		return new ResponseEntity<>("Record Inserted", HttpStatus.OK);
	}

	@Override
	public List<PatientEntity> getAllPatient() {

		// database call to get all patients
		List<PatientEntity> patientList = patientRepo.findAll();

		return patientList;
	}

	@Override
	public PatientEntity getPatientById(int patientId) throws PatientServiceException {
		// get patient by Id
		// PatientEntity patientEntity = patientRepo.findById(patientId).get();
		Optional<PatientEntity> findById = patientRepo.findById(patientId);
		PatientEntity patientEntity = findById.orElse(null);
		if (patientEntity == null) {
			throw new PatientServiceException("101", "Invalid Patient ID");
		}
		return patientEntity;
	}

	@Override
	public PatientDTO updatePatientByID(int patientId, PatientEntity patientEntity) {

		patientEntity.setId(patientId);
		PatientEntity entity = patientRepo.save(patientEntity);

		PatientDTO dto = new PatientDTO();
		dto.setId(entity.getId());
		dto.setPatientAge(entity.getPatientAge());
		dto.setPatientDisease(entity.getPatientDisease());
		dto.setPatientDOB(entity.getPatientDOB());
		dto.setPatientName(entity.getPatientName());
		if (entity.getPatientName().equalsIgnoreCase("Kishor D")) {
			dto.setPatientName("Kishor JAVA");
		}
		return dto;
	}

	@Override
	public void deletePatientById(int patientId) {

		patientRepo.deleteById(patientId);
	}
	
	public double div(int a, int b) {
		return a/b;
	}
}