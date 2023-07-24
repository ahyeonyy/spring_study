package com.example.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("/listgoods")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@RequestMapping("/detailGoods")
	public void detailGoods(Model model, int no) {
		model.addAttribute("g",dao.detailGoods(no));
	}
	
	
	@RequestMapping("/deletegoods")
	public ModelAndView delete(int no , HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listgoods");
		String path = request.getServletContext().getRealPath("images");
		String fname = dao.detailGoods(no).getFname();
		try {
		int re = dao.delete(no);
		if(re==1) {
			File file = new File(path+"/"+fname);
			file.delete();
		}
		} catch (Exception e) {
			mav.addObject("msg", e.getMessage());
			
		}
		return mav;
	}
	
	/*
	@GetMapping("/insertgoods")
	public void insertForm() {
	}
	
	@PostMapping("/insertgoods")
	public ModelAndView insertOK(GoodsVO g) {
		ModelAndView mav = new ModelAndView("redirect:/listgoods");
		int re = dao.insert(g);
		if (re != 1) {
			mav.setViewName("error");
			mav.addObject("msg","등록실패!");
		}
		return mav;
	}
	*/
}
