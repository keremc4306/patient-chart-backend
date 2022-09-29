package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.Polyclinic;

@Repository
public interface PolyclinicRepository extends JpaRepository<Polyclinic, Integer>{
	
}
