package com.patient.patientservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PatientServiceException.class)
	public ResponseEntity<String> invalidPatientException(PatientServiceException ex) {
		return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.NOT_FOUND);
	}
	
	/*
	 * @ExceptionHandler(NoSuchFieldException.class) public ResponseEntity<String>
	 * invalidatientException(NoSuchFieldException ex) { return new
	 * ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); }
	 */

}
