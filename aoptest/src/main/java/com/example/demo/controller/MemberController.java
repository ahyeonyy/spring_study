package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CommonUtil;

import lombok.Setter;
@Setter
@RestController
public class MemberController {
	
	@Autowired
	private CommonUtil util;
	@GetMapping("/listMember")
	public String list() {
		return "회원목록";
	}
}