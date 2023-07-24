package com.example.demo.controller;

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
public class BookController {
	@Autowired
	private BookDAO dao;

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("deleteBook")
	public ModelAndView delete(int bookid) {
		ModelAndView mav = new ModelAndView();
		int re = dao.delete(bookid);
		if (re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "삭제 실패 ! ");
		}else {
			mav.setViewName("redirect:/listbook");
		}
		return mav;
	}
	
	@PostMapping("updatebook")
	public ModelAndView updateOK(BookVO b) {
		ModelAndView mav = new ModelAndView();
		int re = dao.updateDetail(b);
		if(re ==1 ) {
			mav.setViewName("redirect:/detailBook?bookid="+b.getBookid());
		}else {
			mav.addObject("msg", "수정실패!");
		}
		return mav;
	}
	@GetMapping("/updatebook")
	public void update(int bookid, Model model) {
		model.addAttribute("b", dao.getDetail(bookid));
	}
	
	@GetMapping("/detailBook")
	public void detail(int bookid, Model model) {
		model.addAttribute("b", dao.getDetail(bookid));
	}
	
	@GetMapping("/insertbook")
	public void insertBook(Model model) {
		model.addAttribute("bookid", dao.getNextBookid());
	}
	
	@PostMapping("/insertbook")
	public ModelAndView insertbook(BookVO b) {
		ModelAndView mav = new ModelAndView();
		int re = dao.insertBook(b);
		if (re == 1) {
			mav.setViewName("redirect:/listbook");
		}else {
			mav.setViewName("error");
			mav.addObject("msg", "도서 등록 실패 ! ");
		}
		return mav;
	}
	
	
	@RequestMapping("/listbook")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("listbook");
		mav.addObject("list",dao.listbook());
		return mav;
	}
}
