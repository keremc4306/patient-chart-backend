package com.example.hospital.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.dto.AppointmentDto;
import com.example.hospital.service.AppointmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	
	@GetMapping()
	public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
		return ResponseEntity.ok(this.appointmentService.getAppointments());
	}
	
	@PostMapping("/add")
	public ResponseEntity<AppointmentDto> 
		createAppointment(@RequestBody AppointmentDto appointmentDto) {
		final AppointmentDto appointmentCreated 
			= this.appointmentService.createAppointment(appointmentDto);
		return ResponseEntity
				.created(URI.create(appointmentCreated.getAppId()
				.toString())).body(appointmentCreated);
	}
	
	@PutMapping(value = "/{appId}")
	public ResponseEntity<AppointmentDto> 
		updateAppointment(@PathVariable(value = "appId") int appId, 
					      @RequestBody AppointmentDto appointmentDto) {
		return ResponseEntity.accepted()
				.body(this.appointmentService.updateAppointment(appId, appointmentDto));
	}
	
	@DeleteMapping(value = "/{appId}")
	public ResponseEntity<Void> 
		removeAppointment(@PathVariable(value = "appId") int appId) {
		this.appointmentService.removeAppointment(appId);
		return ResponseEntity.accepted().build();
	}
	
}
