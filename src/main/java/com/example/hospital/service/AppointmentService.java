package com.example.hospital.service;

import java.util.List;

import com.example.hospital.dto.AppointmentDto;

public interface AppointmentService {
	AppointmentDto createAppointment(AppointmentDto appointmentDto);
	List<AppointmentDto> getAppointments();
	AppointmentDto updateAppointment(int appId, AppointmentDto appointmentDto);
	void removeAppointment(int appId);
	void checkAppointmentExists(int appId);
}
