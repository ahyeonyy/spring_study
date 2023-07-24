package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class EmpController {
	@GetMapping("/listEmp")
	public String list(HttpServletRequest request) {
		return "사원목록";
	}
}
