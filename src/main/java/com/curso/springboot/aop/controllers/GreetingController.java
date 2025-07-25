package com.curso.springboot.aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.aop.services.GreetingService;

@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService service;
	
	
	@GetMapping("/greeting")
	
	public ResponseEntity<?> greeting()
	{
		return ResponseEntity.ok(Collections.singletonMap("greeting", service.sayHello("Luis", "Hi! How are you")));
	}
	
@GetMapping("/greeting-error")
	
	public ResponseEntity<?> greetingError()
	{
		return ResponseEntity.ok(Collections.singletonMap("greeting", service.sayHelloError("Luis", "Hi! How are you")));
	}
	

}
