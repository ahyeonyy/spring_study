package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@GetMapping("/service1")
	public void service1(HttpSession session) {
		// 인증된(로그인) 회원의 정보를 갖고오기 위하여
		// 먼저 시큐리티의 인증객체 필요 
		Authentication authentication
		= SecurityContextHolder.getContext().getAuthentication();

		// 이 인증 객체를 통해서 인증된(로그인한) user객체를 받아오기 ! 
		User user = (User)authentication.getPrincipal();
		
		// 이 인증된 user를 통해서 로그인한 회원의 아이디를 가져옴
		String id = user.getUsername();
		
		// 이 정보를 세션에 상태유지함
		// 만약, id뿐 아니라 로그인한 회원의 다른 정보도 필요하다면 
		// dao를 통해 회원의 정보를 가져와서 상태유지함
		
		session.setAttribute("id", id);
		
	}
	@GetMapping("/join")
	public void join() {
	}
	@PostMapping("/join")
	public ModelAndView joinsubmit(MemberVO m) {
		ModelAndView mav = new ModelAndView();
//		m.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(m.getPwd()));
		m.setPwd(passwordEncoder.encode(m.getPwd()));
		
		try {
			int re = dao.insert(m);
			if(re == 1) {
				mav.setViewName("redirect:/login");
			}else {
				mav.setViewName("error");
				mav.addObject("msg", "회원가입에 실패했습니다.");
			}
		} catch (Exception e) {
			mav.setViewName("error");
			mav.addObject("msg", "회원가입에 실패했습니다.");
		}
		
		return mav;
	}
}
