package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello") //templates 안에서 hello.html을 찾음 
	public void hello(Model model) {
		model.addAttribute("title", "아현이는 천재만재");
	}
}
