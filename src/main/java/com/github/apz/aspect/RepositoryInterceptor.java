package com.github.apz.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class RepositoryInterceptor {
	@Before("execution(* com.github.apz.repository.*Repository.*(..))")
    public void repositoryBefore(JoinPoint joinpoint) {
		log.info("aop-before: {}" , joinpoint.getSignature());

		String methodName = joinpoint.getSignature().getName();

    }
}
