/*
package com.example.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonController {
	
	@Pointcut("execution (public * com.example.demo.controller..*(..))")
	public void beforeController() {}
	
//	@Around("beforeController()")
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
			
			long start = System.currentTimeMillis();
			
			obj = joinPoint.proceed(); //타겟 메소드 호출
			
			long end = System.currentTimeMillis();
			long delay = end - start;
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"/"+delay);
		} catch (Throwable e) {
			// TODO: handle exception
		}
		return obj;
	}
	
	/*
	@Before("beforeController()")
	public void pro() {
		System.out.println("컨트롤러 동작하기 전 ");
	}
	
}


*/














