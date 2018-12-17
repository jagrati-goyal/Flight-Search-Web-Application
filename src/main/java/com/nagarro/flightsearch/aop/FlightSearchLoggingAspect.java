package com.nagarro.flightsearch.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.nagarro.flightsearch.constants.Constants;

/**
 * The class {@link FlightSearchLoggingAspect} is a Component.<br>
 * This class is responsible for logging all the functionalities happening throughout
 * the application.
 * 
 * @author jagratigoyal
 */

@Aspect
@Component
public class FlightSearchLoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.nagarro.controller.*.*(..))")
	private void forControllerPackage() {
		// Pointcut to execute on all the methods of classes in controller package
	}

	@Pointcut("execution(* com.nagarro.service.*.*(..))")
	private void forServicePackage() {
		// Pointcut to execute on all the methods of classes in service package
	}

	@Pointcut("execution(* com.nagarro.dao.*.*(..))")
	private void forDAOPackage() {
		// Pointcut to execute on all the methods of classes in DAO package
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forApplication() {
		// Pointcut to execute on all the methods of classes in controller, service and DAO package
	}
	
	// execute before the method execution
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info(Constants.BEFORE_ASPECT_INFO + methodName);
	}

	// execute after the method is returned a result
	@AfterReturning(pointcut = "forApplication()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info(Constants.AFTER_RETURNING_INFO + methodName);
		logger.info(Constants.AFTER_RETURNING_RESULT_INFO + result);
	}

}
