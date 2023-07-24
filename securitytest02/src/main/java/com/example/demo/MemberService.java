package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Service
@Setter
public class MemberService implements UserDetailsService {
	@Autowired
	private MemberDAO dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("로그인 처리 : loadUserByUsername 자동으로 동작함 !");
		MemberVO m = dao.findById(username);
		if (m == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return User.builder().username(username)
				.password(m.getPwd())
				.roles(m.getRole()).build();
	}

}
