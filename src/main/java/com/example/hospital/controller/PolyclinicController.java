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

import com.example.hospital.entity.Polyclinic;
import com.example.hospital.exception.ResourceNotFoundException;
import com.example.hospital.repository.PolyclinicRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/polyclinics")
public class PolyclinicController {
	
	@Autowired
	private PolyclinicRepository polyclinicRepository;
	
	@GetMapping()
	public List<Polyclinic> getAllPolyclinics() {
		return polyclinicRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Polyclinic getByPolyclinicId(@PathVariable int id) {
		return polyclinicRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Polyclinic does not "
						+ "exist with " + "id :" + id));
	}
	
	@PostMapping("/add")
	public Polyclinic createPolyclinic(@RequestBody Polyclinic polyclinic) {
		return polyclinicRepository.save(polyclinic);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Polyclinic> updatePolyclinic(@PathVariable int id, 
			@RequestBody Polyclinic polyclinicDetails) {
		Polyclinic polyclinic = polyclinicRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Polyclinic does not "
						+ "exist with " + "id:" + id));
		
		polyclinic.setPolyName(polyclinicDetails.getPolyName());
		polyclinic.setPolyPrice(polyclinicDetails.getPolyPrice());
		
		Polyclinic updatedPolyclinic = polyclinicRepository.save(polyclinic);
		return ResponseEntity.ok(updatedPolyclinic);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Map<String, Boolean>>
		    deletePolyclinic(@RequestBody List<Polyclinic> polyclinics) {
		polyclinicRepository.deleteAll(polyclinics);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
