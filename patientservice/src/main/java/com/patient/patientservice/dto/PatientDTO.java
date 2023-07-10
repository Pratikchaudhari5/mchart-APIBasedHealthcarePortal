package com.patient.patientservice.dto;

import java.sql.Date;

public class PatientDTO {

	private int id;
	private String patientName;
	private String patientDisease;
	private Date patientDOB;
	private int patientAge;

	// getter and setter methods to access the value
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientDisease() {
		return patientDisease;
	}

	public void setPatientDisease(String patientDisease) {
		this.patientDisease = patientDisease;
	}

	public Date getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(Date patientDOB) {
		this.patientDOB = patientDOB;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	// to print the values of object

	@Override
	public String toString() {
		return "PatientDTO [id=" + id + ", patientName=" + patientName + ", patientDisease=" + patientDisease
				+ ", patientDOB=" + patientDOB + ", patientAge=" + patientAge + "]";
	}

}