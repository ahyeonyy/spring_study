package com.example.demo.common;

import java.io.FileWriter;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Aspect
public class WriteFileLog {
	@Pointcut("execution (public * com.example.demo.controller..*(..))")
	public void sistlog() {}
	
	@Around("sistlog()")
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		String methodName = joinPoint.getSignature().toShortString();
		Object[]args= joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)args[0];
		String ip = request.getRemoteAddr();
		String uri = request.getRequestURI();
		
		try {
			long start = System.currentTimeMillis();
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			long delay = end - start;
			String data = uri +"/" + methodName +"/" + ip +"/" + delay +"\n";
			Date today = new Date();
			int year = today.getYear()+1900;
			String fname = "/Users/ahyeonlee/Desktop/spring_Study/sist_log/"+year;
			int month = today.getMonth()+1;
			int date = today.getDate();
			
			if (month < 10) {
				fname += "0"+month;
			}else {
				fname += month;
			}
			if (date < 10) {
				fname += "0"+date;
			}else {
				fname += date;
			}
			fname += ".txt";
			
			FileWriter fw = new FileWriter(fname, true);
			fw.write(data);
			fw.close();
			
		} catch (Throwable e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		
		return obj;
	}
}
















