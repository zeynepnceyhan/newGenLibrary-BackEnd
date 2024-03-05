package com.swe.newGenLibrary.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swe.newGenLibrary.business.abstracts.AuthService;
import com.swe.newGenLibrary.entities.SignupDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8081")
public class SignupUserController {
	
	private AuthService authService;

	@Autowired
	public SignupUserController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public Mono<?> createUser(@RequestBody SignupDto signupDto) {
	    return Mono.fromCallable(() -> {
	        return this.authService.createUser(signupDto);
	    })
	    .map(result -> {
	        // İşlem başarılıysa
	        return ResponseEntity.ok(result);
	    });

	}

}
