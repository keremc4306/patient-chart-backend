package com.example.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	@Query("select distinct p.gender from Patient p")
	List<String> getAllGender();
}
