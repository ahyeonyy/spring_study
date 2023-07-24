package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/admin/admin1")
	public void admin1() {
		System.out.println("admin 컨트롤러의 메뉴 1! 요청 처리 랄랄라 ~ ");
	}
	@GetMapping("/admin/admin2")
	public void admin2() {
		System.out.println("admin 컨트롤러의 메뉴 2! 요청 처리 랄랄라 ~ ");
	}
}
