package com.example.hospital.entity;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_id")
	private Integer appId;
	
	@Column(name = "patient_id")
	private Integer patientId;
	
	@Column(name = "pol_id")
	private Integer polId;
	
	@Column(name = "app_date")
	private Date appDate;
	
	@Column(name = "app_time")
	private LocalTime appTime;
}
