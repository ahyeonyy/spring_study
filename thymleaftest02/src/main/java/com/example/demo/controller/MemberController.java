package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
@RestController
public class MemberController {
	
	@GetMapping("/listMember")
	public String list(HttpServletRequest request) {
		return "회원목록";
	}
}
