/*
package com.example.demo.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoCommon {
	
	@Pointcut("execution (public * com.example.demo.dao..*(..))")
	private void pro() {}
	
	
	//타깃메소드가 정상완료하거나 비정상완료하거 
	//반드시 동작하는 어드바이스를 만들고 결과를 확인 해 봅니다.
	@After("pro()")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"메소드가 완료되었습니다.");
	}
	
	
	//타깃메소드가 비정상 완료되었을때 동작하는 어드바이스를
	//만들고 결과를 확인 해 봅니다.
//	@AfterThrowing("pro()")
	public void afterThrowing(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"메소드가 비정상 완료되었습니다.");
	}
	
	
	
	//@AfterReturning("pro()")
	public void afterReturn(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"메소드가 정상완료하였습니다.");
	}
	
	
	
	
	
	//@Before("pro()")
	public void before(JoinPoint joinPoint) {
		String methodName = 
				joinPoint.getSignature().getName();
		String name1 = joinPoint.getSignature().toLongString();
		String name2 = joinPoint.getSignature().toShortString();
	
				
		System.out.println(methodName+ " 메소드 동작하기 전입니다.");
		System.out.println("toLongString:"+name1);
		System.out.println("toShortString:"+name2);
		
	}
	
	
	
//	@Around("pro()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
			long start = System.currentTimeMillis();
			System.out.println("타깃메소드 동작하기 전입니다.");
			
			//타깃메소드를 호출함.		
			obj = joinPoint.proceed(); // 전 후를 나눈 기준 점 
			
			long end = System.currentTimeMillis();
			System.out.println("타깃메소드 동작후입니다.");
			System.out.println("걸린시간:"+(end-start));
			
			
		}catch (Throwable e) {
			// TODO: handle exception
		}
		return obj;
	}
}
*/