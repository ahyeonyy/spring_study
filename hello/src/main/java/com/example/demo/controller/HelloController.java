package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	@ResponseBody
	public String hello() {	
		return "<h1>집에 가장 ~ </h1>";
	}
}
