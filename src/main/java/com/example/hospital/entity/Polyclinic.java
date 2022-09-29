package com.example.hospital.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "polyclinics")
@AllArgsConstructor
@NoArgsConstructor
public class Polyclinic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pol_id")
	private Integer id;
	
	@Column(name = "pol_name")
	private String polyName;
	
	@Column(name = "pol_price")
	private int polyPrice;
	
	//@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//private List<Appointment> appointments;
	
	@OneToMany(mappedBy = "polyclinic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Receipt> receipts;
}
