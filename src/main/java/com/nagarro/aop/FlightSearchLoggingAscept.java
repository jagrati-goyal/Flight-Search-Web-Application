package com.nagarro.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.nagarro.constants.Constants;

@Aspect
@Component
public class FlightSearchLoggingAscept {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.nagarro.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.nagarro.controller.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.nagarro.controller.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forApplication() {
	}

	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info(Constants.BEFORE_ASPECT_INFO + methodName);
	}

	@AfterReturning(pointcut = "forApplication()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info(Constants.AFTER_RETURNING_INFO + methodName);
		logger.info(Constants.AFTER_RETURNING_RESULT_INFO + result);
	}
	
}
