package com.primesoft.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.primesoft.binding.CitizenApp;
import com.primesoft.service.ArService;

@RestController
public class ArRestController {
	
	@Autowired
	private ArService service;
	
	@PostMapping("/app")
	public ResponseEntity<String> createCitizenApp(@RequestBody CitizenApp app){
		
		Integer appId = service.createApplication(app);
		
		if(appId >0) {
			return new ResponseEntity<>("App Created with App Id :"+appId,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Invalid SSN",HttpStatus.BAD_REQUEST);
		}
	}
/*	
	@GetMapping("/hello")
	public String home() {
		return "Hello world";
	}
	
	@GetMapping("/data")
	public CitizenApp getDetail() {
		
		
		 String fullname="Hari";
		
		 String email="Hari@gmail.com";
		
		 Long phno= 456677L;
		
		 String gender="Male";
		
		 Long ssn= 55667L;
		
		 LocalDate dob = null;
		 
		 
		 CitizenApp app= new CitizenApp();
		 
		 app.setDob(dob);
		 app.setEmail(email);
		 app.setFullname(fullname);
		 app.setGender(gender);
		 app.setPhno(phno);
		 app.setSsn(ssn);
		
		
		return app;
	}
*/
}
