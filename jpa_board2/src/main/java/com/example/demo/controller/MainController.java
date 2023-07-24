package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/hello")
	public String hello( HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/images/");
		System.out.println("path:"+path);
		return "ok";
				
	}
}
