package com.example.bettererrorpagesdemo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class DebuggingAspect {

	@Pointcut("execution(* org.springframework.boot.web.servlet.error.DefaultErrorAttributes.getErrorAttributes(..))")
	public void errorHtmlGeneration() {
	}

	@Around("com.example.bettererrorpagesdemo.DebuggingAspect.errorHtmlGeneration()")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		Map<String, Object> errorAttributes = (Map<String, Object>) joinPoint.proceed();

		final ClassPathResource classPathResource = new ClassPathResource("trace.txt");
		if (classPathResource.exists()) {

			final String trace = new String(Files.readAllBytes(classPathResource.getFile().toPath()), StandardCharsets.UTF_8);
			errorAttributes.put("trace", trace);
			log.info("trace is replaced.");
		}

		return errorAttributes;
	}

}