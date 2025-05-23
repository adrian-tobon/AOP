package com.curso.springboot.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {
	
	private final Logger logger = LoggerFactory.getLogger(GreetingAspect.class);
	
	
	@Before("execution(* com.curso.springboot.aop.services.GreetingService.sayHello(..))")
	public void loggerBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Metodo: " + method + "Argumentos" + args );
	}

}
