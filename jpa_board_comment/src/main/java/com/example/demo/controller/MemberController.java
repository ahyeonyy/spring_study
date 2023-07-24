package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@PostMapping("/member/login")
	public String loginOK(String id, String pwd, HttpSession session) {
		String view = "redirect:/board/list";
		Member m = dao.isMember(id, pwd);
		if( m == null ) {
			view = "redirect:/memebr/login.html";
		}else {
			session.setAttribute("id",id);
		}
		return view;
	}
}
