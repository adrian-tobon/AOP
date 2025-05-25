package com.curso.springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCuts {
	
	@Pointcut("execution(* com.curso.springboot.aop.services.GreetingService.*(..))")
	public void GreetingLoggerPointCut() {}

}
