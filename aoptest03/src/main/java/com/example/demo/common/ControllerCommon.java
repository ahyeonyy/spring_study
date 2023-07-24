/*
package com.example.demo.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerCommon {
	@Pointcut("execution (public * com.example.demo.controller..*(..))")
	private void pro() {
		// void여야 하고, 몸통에 무언가있어도 의미가 없다 ~ 
		// 실행 안된다 ! 
	}
	
	@Before("pro()")
	public void before(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		String name1 = joinPoint.getSignature().toLongString();
		String name2 = joinPoint.getSignature().toShortString();
		
		System.out.println(methodName+ " 메소드 동작하기 전입니다.");
		System.out.println("toLongString:"+name1);
		System.out.println("toShortString:"+name2);
		}
}
*/