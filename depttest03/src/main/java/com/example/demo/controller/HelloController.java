package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView  hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "안녕 스프링!");
		mav.setViewName("hello");
		return mav;
	}
}
