package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.CommonUtil;
import com.example.demo.dao.BookDAO;

import lombok.Setter;

@Setter
@Controller
public class BookController {
	@Autowired
	private CommonUtil util;
	
	@Autowired
	private BookDAO dao;
	
	@GetMapping("/listBook")
	public void listbook(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
}















