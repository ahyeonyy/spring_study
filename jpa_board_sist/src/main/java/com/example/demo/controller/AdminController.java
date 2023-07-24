package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;

@Controller
public class AdminController {
	private MemberDAO dao;
	
	@GetMapping("/admin/index")
	public void index(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@GetMapping("/admin/member/delete/{id}")
	public ModelAndView memberDelete(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView("redirect:/admin/index");
		dao.deleteById(id);
		return mav;
		
	}
}
