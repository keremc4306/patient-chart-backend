package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.Polyclinic;
import com.example.hospital.repository.PolyclinicRepository;

@Service
public class PolyclinicService {
	
	@Autowired
	PolyclinicRepository polyclinicRepository;
	
	public Polyclinic createPolyclinic(Polyclinic polyclinic) {
		polyclinicRepository.save(polyclinic);
		return polyclinic;
	}
	
	public List<Polyclinic> viewPolyclinic(Polyclinic polyclinic) {
		return polyclinicRepository.findAll();
	}
	
	public Polyclinic deletePolyclinic(Polyclinic polyclinic) {
		polyclinicRepository.delete(polyclinic);
		return polyclinic;
	}
}
