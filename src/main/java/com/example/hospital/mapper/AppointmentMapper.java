package com.example.hospital.mapper;

import java.util.List;
import java.util.Objects;

import com.example.hospital.dto.AppointmentDto;
import com.example.hospital.entity.Appointment;

public class AppointmentMapper {

	private AppointmentMapper() {
		throw new IllegalStateException(String.format("%s is a utility class", this.getClass().getCanonicalName()));
	}
	
	public static Appointment toEntity(AppointmentDto appointmentDto) {
		if (Objects.isNull(appointmentDto))
			return null;
		
		return Appointment.builder()
			.patientId(appointmentDto.getPatientId())
			.polId(appointmentDto.getPolyclinicId())
			.appDate(appointmentDto.getAppDate())
			.appTime(appointmentDto.getAppTime())
			.build();		
	}
	
	public static AppointmentDto toDto(Appointment appointment) {
		if (Objects.isNull(appointment))
			return null;
		
		return AppointmentDto.builder()
			.appId(appointment.getAppId())
			.patientId(appointment.getPatientId())
			.polyclinicId(appointment.getPolId())
			.appDate(appointment.getAppDate())
			.appTime(appointment.getAppTime())
			.build();
	}
	
	 public static List<Appointment> toEntityList(List<AppointmentDto> appointmentDtoList) {
		    return appointmentDtoList.stream().parallel()
		        .map(AppointmentMapper::toEntity)
		        .toList();
		  }
	
	public static List<AppointmentDto> toDtoList(List<Appointment> appointmentList) {
		return appointmentList.stream().parallel()
				.map(AppointmentMapper::toDto)
				.toList();
	}
}
