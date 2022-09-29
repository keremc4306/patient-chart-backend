package com.example.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.entity.Patient;
import com.example.hospital.exception.ResourceNotFoundException;
import com.example.hospital.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping()
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@GetMapping("/{id}")
	public Patient getByPatientId(@PathVariable int id) {
		return patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient does not exist with " + "id :" + id));
	}

	@PostMapping("/add")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int id, 
			@RequestBody Patient patientDetails) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient does not exist with " + "id:" + id));

		patient.setFirstName(patientDetails.getFirstName());
		patient.setLastName(patientDetails.getLastName());
		patient.setAge(patientDetails.getAge());
		patient.setGender(patientDetails.getGender());
		patient.setJob(patientDetails.getJob());

		Patient updatedPatient = patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}

	@PostMapping("/delete")
	public ResponseEntity<Map<String, Boolean>> 
			deleteProduct(@RequestBody List<Patient> patients) {
		patientRepository.deleteAll(patients);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/genders")
	public List<String> getGenders() {
		return patientRepository.getAllGender();
	}
}
