package com.curso.springboot.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingTwoAspect {
	
	private final Logger logger = LoggerFactory.getLogger(GreetingTwoAspect.class);
	
	/*@Pointcut("execution(* com.curso.springboot.aop.services.GreetingService.*(..))")
	private void GreetingLoggerPointCut() {}*/
	
	
	@Before("GreetingServicePointCuts.GreetingLoggerPointCut()")
	public void loggerBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Inicio Segundo Aspecto Metodo: " + method + " Argumentos" + args );
	}

	@AfterReturning("GreetingServicePointCuts.GreetingLoggerPointCut()")
	public void loggerAfterReturning(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Ejecucion exitosa Segundo Aspecto Metodo: " + method + " Argumentos" + args );
	}
	
	@AfterThrowing("GreetingServicePointCuts.GreetingLoggerPointCut()")
	public void loggerAfterThrowing(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Ejecucion fallida Segundo Aspecto Metodo: " + method + " Argumentos" + args );
	}
	
	
}
