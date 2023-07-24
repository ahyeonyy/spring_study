package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Setter
@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	@PostMapping("/insert")
	public ModelAndView insert(MemberVO m) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		int re = dao.insert(m);
		
		return mav;
	}
}
