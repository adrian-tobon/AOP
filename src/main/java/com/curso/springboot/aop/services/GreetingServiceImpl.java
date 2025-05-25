package com.curso.springboot.aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

	@Override
	public String sayHello(String person, String phrase) {
		String greeting = phrase.concat(" ").concat(person);
		
		return greeting;
	}

	@Override
	public String sayHelloError(String person, String phrase) {
		throw new RuntimeException("Error de prueba");
	}

	
	
}
