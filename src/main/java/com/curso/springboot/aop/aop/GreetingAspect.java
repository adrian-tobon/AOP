package com.curso.springboot.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {
	
	private final Logger logger = LoggerFactory.getLogger(GreetingAspect.class);
	
	
	/*@Before("execution(* com.curso.springboot.aop.services.GreetingService.*(..))")
	public void loggerBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Inicio ejecucion Metodo: " + method + "Argumentos" + args );
	}*/

	/*@After("execution(* com.curso.springboot.aop.services.GreetingService.*(..))")
	public void loggerAfter(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Fin Ejecucion Metodo: " + method + "Argumentos" + args );
	}*/
	
	/*@AfterReturning("execution(* com.curso.springboot.aop.services.GreetingService.*(..))")
	public void loggerAfterReturning(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Ejecucion exitosa Metodo: " + method + "Argumentos" + args );
	}*/
	
	
	@AfterThrowing("execution(* com.curso.springboot.aop.services.GreetingService.*(..))")
	public void loggerAfterThrowing(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Ejecucion fallida Metodo: " + method + "Argumentos" + args );
	}
	
	@Around("execution(* com.curso.springboot.aop.services.GreetingService.*(..))")
	public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		Object result = null;
		try {
			logger.info("Antes ejecucion: " + method + " Argumentos" + args );
			result = joinPoint.proceed();
			logger.info("Despues ejecucion: " + method + " Argumentos" + args );
			return result;
		} catch (Throwable e) {			
			logger.error("error en la llamada del metodo: " + method);
			throw e;
		}		
	}
}
