package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@Controller
public class Book2Controller {
	
	
	@Autowired
	private BookDAO dao;
	
	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	@GetMapping("/updatebook")
	public void updateForm(Model model, int bookid) {
		model.addAttribute("b",dao.findByBookId(bookid));
	}
	
	@GetMapping("deletebook")
	public ModelAndView delete(int bookid) {
		int re = dao.delete(bookid);
		ModelAndView mav = new ModelAndView("redirect:/listbook");
		if (re != 1) {
			mav.addObject("msg", "삭제실패1!");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@PostMapping("/updatebook")
	public ModelAndView updateSubmit(BookVO b) {
		ModelAndView mav = new ModelAndView();
		int re = dao.update(b);
		System.out.println(b.getBookid());
		if(re != 1 ) {
			mav.setViewName("error");
			mav.addObject("msg", "수정 실패 ! ");
		}else {
			mav.setViewName("redirect:/detailbook?bookid="+b.getBookid());
		}
		return mav;
	}
	
	@GetMapping("/insertbook")
	public void insert() {
	}
	
	@PostMapping("/insertbook") 
		public ModelAndView insert(BookVO b) {
			ModelAndView mav = new ModelAndView();
			int re = dao.insert(b);
			if (re == 1) {
				mav.setViewName("redirect:/listbook");
			}else {
				mav.addObject("msg", "등록 실패!");
				mav.setViewName("error");
			}
			return mav;
		}
	@RequestMapping("/detailbook")
	public void detailbook(int bookid,Model model) {
		model.addAttribute("b",dao.findByBookId(bookid));
	}

	@RequestMapping("/listbook")
	public void list(Model model,String keyword,String keyfield, String op) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("op", op);
		map.put("keyfield",keyfield);
		map.put("keyword",keyword);
		model.addAttribute("list", dao.findAll(map));
	}
}
