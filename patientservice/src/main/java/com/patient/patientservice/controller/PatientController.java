package com.patient.patientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.patientservice.dto.PatientDTO;
import com.patient.patientservice.entities.PatientEntity;
import com.patient.patientservice.exception.PatientServiceException;
import com.patient.patientservice.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	// Controller layer

	@Autowired // create an object and inject it where it is required
	private PatientService patientService;

	// handler method to add patient in database
	@PostMapping(value = "/addPatient")
	public ResponseEntity<String> addPatientToDB(@RequestBody PatientDTO patientDTO) {
		ResponseEntity<String> responseEntity = patientService.addPatientToDB(patientDTO);
		return responseEntity;

	}

	// get all patients
	@GetMapping(value = "/all")
	public ResponseEntity<List<PatientEntity>> getAllPatient() {
		List<PatientEntity> patientList = patientService.getAllPatient();
		// returning responseEntity obj as body
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(patientList);
	}

	// get patient by Id
	@GetMapping(value = "/{patientId}")
	public ResponseEntity<PatientEntity> getPatientById(@PathVariable("patientId") int patientId) throws PatientServiceException {
		PatientEntity entity = patientService.getPatientById(patientId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(entity);
	}

	// To update the existing record by ID
	@PutMapping(value = "/{patientId}")
	public ResponseEntity<PatientDTO> updatePatientByID(@PathVariable("patientId") int patientId,
			@RequestBody PatientEntity patientEntity) {
		PatientDTO patientResponse = patientService.updatePatientByID(patientId, patientEntity);
		return ResponseEntity.ok().body(patientResponse);
	}

	// Delete API
	@DeleteMapping(value = "/{patientId}")
	public ResponseEntity<String> deletePatientById(@PathVariable("patientId") int patientId) {
		patientService.deletePatientById(patientId);
		return new ResponseEntity<>("Record Deleted", HttpStatus.OK);
	}

}