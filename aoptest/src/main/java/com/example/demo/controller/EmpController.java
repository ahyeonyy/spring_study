package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CommonUtil;

import lombok.Setter;
@Setter
@RestController
public class EmpController {
	@Autowired
	private CommonUtil util;
	@GetMapping("/listEmp")
	public String list() {
		return "사원목록";
	}
}
