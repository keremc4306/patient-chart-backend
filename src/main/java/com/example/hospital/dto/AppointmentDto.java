package com.example.hospital.dto;

import java.sql.Date;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
	private Integer appId;
	private Integer patientId;
	private Integer polyclinicId;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date appDate;
	@JsonFormat(pattern = "HH:mm")
	private LocalTime appTime;
}
