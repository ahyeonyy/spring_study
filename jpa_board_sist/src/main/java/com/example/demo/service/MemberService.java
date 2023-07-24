package com.example.demo.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;

import lombok.Setter;

@Service
@Setter
public class MemberService implements UserDetailsService {
	@Autowired
	private MemberDAO dao;
	
	
	// 스프링 시큐리티에서는 로그인을 위한 get	방식에 대한 form 태그는 우리 마음대로
	// 만들 수 있지만, 실제 로그인 처리는 우리가 하지않고 , 
	// 시큐리티가 알아서 처리해
	// 이때 다음의 loadUserByUsername 메소드가 동작
	// 이 메ㄷ소드는 매개변수로 사용자가 입력한 아이디가 전달되고,
	// 우리는 이 아이디에 해당하는 회원의 정보를 DAO로부터 가져온 다음
	// UserDetails 객체를 생성하면 반환하도록 만들어야함
	// 그 나머지 암호가 맞는지 , 어떤 서비스를 위하여 권한이 있는지 등은
	// 시큐리티가 판별함 
	// 만약 해당 id의 고객이 없으면 예외 발생
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = null;
		
//		dao.save(new Member("ahyeon1", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"), "혀니111!", "user"));
//		dao.save(new Member("king", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"), "덕수양", "user"));
		
		Member m = dao.findById(username).get();
		if(m == null) {
			try {
				throw new UsernameNotFoundException(username);
			} catch (Exception e) {
				
			}
		}else {
			user = User.builder().username(username) // id 설정
					.password(m.getPwd()) // 비밀번호 설정
					.roles(m.getRole()).build(); // role 설정 
		}
		return user;
	}

}













