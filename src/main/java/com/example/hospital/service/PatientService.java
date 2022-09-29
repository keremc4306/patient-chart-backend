package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.Patient;
import com.example.hospital.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	public Patient createPatient(Patient patient) {
		patientRepository.save(patient);
		return patient;
	}
	
	public List<Patient> viewPatient(Patient patient) {
		return patientRepository.findAll();
	}
	
	public Patient deletePatient(Patient patient) {
		patientRepository.delete(patient);
		return patient;
	}
}
