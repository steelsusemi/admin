package com.jjplatform.admin.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Aspect
@Component
public class LoggerAspect implements HandlerInterceptor{
	private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	
	/**
     *   @GetMapping 설정된 메소드 또는 클래스 설정
     *   GetMapping 노테이션이 설정된 특정 클래스/메소드에만 LoggerAspect가 적용됨.
     */
    @Pointcut("within(com.jjplatform.admin.controller.*)")
    public void GetMapping(){ } 
    		
    /**
    *
    * @param joinPoint
    * @return
    * @throws Throwable
    */
   @Around("GetMapping()")
   public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
	   log.info("=====================LoggerAspect TEST  : Around Logging Start=====================");
	   try {
		   Object result = joinPoint.proceed();
//		   log.info("Around request.getMethod >> "+request.getMethod());
//		   log.info("Around request.getContextPath >> "+request.getContextPath());
//		   log.info("Around request.getRequestURI >> "+request.getRequestURI());
//		   log.info("Around request.getRequestURL >> "+request.getRequestURL());
//		   log.info("Around joinPoint1 >> "+joinPoint.getSourceLocation());
//		   log.info("Around joinPoint2 >> "+joinPoint.getKind());
//		   log.info("Around joinPoint3 >> "+joinPoint.getArgs());
//		   log.info("Around joinPoint4 >> "+joinPoint.getClass());
//		   log.info("Around joinPoint5 >> "+joinPoint.getSignature());
//		   log.info("Around joinPoint6 >> "+joinPoint.getStaticPart());
//		   log.info("Around joinPoint7 >> "+joinPoint.getTarget());
//		   log.info("Around joinPoint8 >> "+joinPoint.getThis());
		   log.info("=====================LoggerAspect TEST  : Around Logging END=====================");
		   return result;
       }catch (Exception e) {
           log.error("=====================LoggerAspect Around Exception=====================");
           log.error(e.toString());
           return null;
       }
   }
 
    /**
     * @param joinPoint
     */
    @Before("GetMapping()")
    public void before(JoinPoint joinPoint) {
    	log.info("Before joinPoint1 >> "+joinPoint.getSourceLocation());
    	log.info("Before joinPoint2 >> "+joinPoint.getKind());
    	log.info("Before joinPoint3 >> "+joinPoint.getArgs());
    	log.info("Before joinPoint4 >> "+joinPoint.getClass());
    	log.info("Before joinPoint4 >> "+joinPoint.getSignature());
    	log.info("Before joinPoint4 >> "+joinPoint.getStaticPart());
    	log.info("Before joinPoint4 >> "+joinPoint.getTarget());
    	log.info("Before joinPoint4 >> "+joinPoint.getThis());
        log.info("=====================LoggerAspect TEST  : Before Logging Start=====================");
        log.info("=====================LoggerAspect TEST  : Before Logging End=====================");
    }

    /**
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "GetMapping()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
    	log.info("AfterReturning joinPoint1 >> "+joinPoint.getSourceLocation());
    	log.info("AfterReturning joinPoint2 >> "+joinPoint.getKind());
    	log.info("AfterReturning joinPoint3 >> "+joinPoint.getArgs());
    	log.info("AfterReturning joinPoint4 >> "+joinPoint.getClass());
    	log.info("AfterReturning joinPoint4 >> "+joinPoint.getSignature());
    	log.info("AfterReturning joinPoint4 >> "+joinPoint.getStaticPart());
    	log.info("AfterReturning joinPoint4 >> "+joinPoint.getTarget());
    	log.info("AfterReturning joinPoint4 >> "+joinPoint.getThis());
    	log.info("AfterReturning result >> "+result);
        log.info("=====================LoggerAspect TEST  : AfterReturning Logging Start=====================");
        log.info("=====================LoggerAspect TEST  : AfterReturning Logging END=====================");
    }
}
