package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BookService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrdersService;
import com.example.demo.service.View_ListOrdersService;
import com.example.demo.vo.OrdersVO;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class OrdersController {
	@Autowired
	private OrdersService os;
	
	@Autowired
	private BookService bs;
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private View_ListOrdersService vs;
	
	@GetMapping("/orders/insert")
	public void insert(Model model) {
		model.addAttribute("no", os.getNextNo());
		model.addAttribute("clist", cs.findAll());
		model.addAttribute("blist", bs.findAll(null,null));
	}
	
	@PostMapping("orders/insert")
	public ModelAndView insert(OrdersVO o) {
		ModelAndView mav = new ModelAndView("redirect:/orders/list");
		os.insert(o);
		return mav;
	}
	
	@GetMapping("orders/list")
	public void list(Model model) {
		model.addAttribute("list", os.list());
	}
	
	@GetMapping(value = {"orders/list2/{column}/{keyword}","orders/list2/{column}/","orders/list2"})
	public ModelAndView list2(@PathVariable(required = false) String column, @PathVariable(required = false) String keyword, String sort, HttpSession session, HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView("/orders/list2");

	    // 세션에 저장된 검색어 사용
	    if ((String) session.getAttribute("keyword") != null && !((String) session.getAttribute("keyword")).equals("")) {
	        column = (String) session.getAttribute("column");
	        keyword = (String) session.getAttribute("keyword");
	    }

	    // 요청 파라미터로부터 검색어 가져오기
	    if (request.getParameter("keyword") != null) {
	        column = request.getParameter("column");
	        keyword = request.getParameter("keyword");
	        
	    }
	    
	    session.setAttribute("keyword", keyword);
	    session.setAttribute("column", column);
	    

	    mav.addObject("list", vs.findAll(column, keyword, sort));

	    System.out.println("keyword: " + keyword);
	    System.out.println("session: " + (String) session.getAttribute("keyword"));

	    return mav;
	}

	
	
}




















