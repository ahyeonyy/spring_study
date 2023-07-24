package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.Setter;

@Configuration
@Setter
public class SpringConfig implements WebMvcConfigurer{
	// 로그인 할 때에는 스프링 시큐리티가 다음의 메소드를 자동으로 요구하여 암호를 인코딩함 
	// 회원가입 할 때에는 사용자가 직접 호출하여 암호를 인코딩해야함.
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/admin/*"); // admin에 있는 모든 요청일때 동작!
	}
	
}
