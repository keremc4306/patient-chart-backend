package com.example.hospital.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.AppointmentDto;
import com.example.hospital.mapper.AppointmentMapper;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
	
	private static final String APPOINTMENT_NOT_FOUND = "Appointment does not exist !!!";
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Override
	public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
		return AppointmentMapper
				.toDto(this.appointmentRepository
				.save(AppointmentMapper.toEntity(appointmentDto)));
	}
	
	@Override
	public AppointmentDto updateAppointment(int appId, AppointmentDto appointmentDto) {
		if (!Objects.equals(appId, appointmentDto.getAppId()))
			throw new IllegalArgumentException("Ids do not match");
		
		this.checkAppointmentExists(appId);
		
		return AppointmentMapper
				.toDto(this.appointmentRepository
				.save(AppointmentMapper.toEntity(appointmentDto)));
	}

	@Override
	public List<AppointmentDto> getAppointments() {
		return AppointmentMapper.toDtoList(this.appointmentRepository.findAll());
	}

	@Override
	public void checkAppointmentExists(int appId) {
		if (Objects.isNull(appId) || this.appointmentRepository.findById(appId).isEmpty())
			throw new NoSuchElementException(APPOINTMENT_NOT_FOUND);
	}

	@Override
	public void removeAppointment(int appId) {
		this.checkAppointmentExists(appId);
		
		this.appointmentRepository.deleteById(appId);
	}
	
}
