package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.CustomerService;
import com.example.demo.vo.CustomerVO;

import lombok.Setter;

@Controller
@Setter
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	@GetMapping("/customer/listcustomer")
	public void listcustomer(Model model) {
		model.addAttribute("list", cs.findAll());
	}
	
	@GetMapping("/customer/insert")
	public void insert() {
	}
	
	@PostMapping("/customer/save")
	public ModelAndView save(CustomerVO c) {
		ModelAndView mav = new ModelAndView("redirect:/customer/listcustomer");
		cs.save(c);
		return mav;
	}
	@GetMapping("/customer/update/{bookid}")
	public ModelAndView update(@PathVariable int bookid ) {
		ModelAndView mav = new ModelAndView("/customer/update");
		mav.addObject("c", cs.getOne(bookid));
		return mav;
	}	
	@GetMapping("/customer/delete/{bookid}")
	public ModelAndView delete(@PathVariable int bookid ) {
		ModelAndView mav = new ModelAndView("redirect:/customer/listcustomer");
		cs.delete(bookid);
		return mav;
	}
}












