package com.example.hospital.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfiguration {
	@Bean
	public ObjectMapper defaultMapper() {
	    ObjectMapper objectMapper = new ObjectMapper(); 
	    objectMapper.registerModule(new JavaTimeModule()); 
	    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	    //objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	    //objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    return objectMapper;
	}
}
