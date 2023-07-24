package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		http.authorizeHttpRequests()
		.mvcMatchers("/","/all/**","/join","/error").permitAll() // 로그인 상관없이 요청가능
		.mvcMatchers("/admin/**").hasRole("admin")
		.anyRequest().authenticated(); 
		
		// 로그인을 위한 서비스 명을 login이라고 하고, 모두가 요청 가능
		// 로그인 성공했을때 service1 요청할거야 
		http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/service1"); 

		// 로그아웃을 위한 서비스명은 /logout 이고 , 세션을 파기하고 login으로 이동
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/login");
		
		
		http.httpBasic();
	}
	
	
}
