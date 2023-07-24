package com.example.demo.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookController {
	@Autowired
	private BookService bs;
	
	@GetMapping(value = {"/book/listBook/{searchColumn}/{keyword}","/book/listBook","/book/listBook/{searchColumn}/"})
	public ModelAndView listSearch(@PathVariable(required = false) String searchColumn,@PathVariable(required = false) String keyword) {
		 ModelAndView mav = new ModelAndView("/book/listBook");
		 System.out.println("서비스 키워드 :"+keyword);
		 mav.addObject("list", bs.findAll(searchColumn,keyword));
		 return mav;
	}
//	
//	@GetMapping("/book/listBook")
//	public void list(String bookname,Model model) {
//			model.addAttribute("list", bs.findAll(bookname));			
//	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/book/insert")
	public void insert() {
	}
	
	@GetMapping("/book/update/{bookid}")
	public ModelAndView update(@PathVariable int bookid) {
		ModelAndView mav = new ModelAndView("/book/update");
		mav.addObject ("b", bs.getOne(bookid));
		return mav;
	}
	
	@GetMapping("/book/delete/{bookid}")
	public ModelAndView delete(@PathVariable int bookid) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		bs.delete(bookid);
		return mav;
	}
	
	@PostMapping("/book/save")
	public ModelAndView save(BookVO b) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		bs.save(b);
		return mav;
	}
	
	
}
