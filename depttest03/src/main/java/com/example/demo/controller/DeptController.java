package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
//	@RequestMapping(value = "/insertDept", method =RequestMethod.GET)
	@GetMapping("/insertDept")
	public void insertForm() { // 뷰이름을 따로 지정하지않아도 요청한 이름의 뷰로 자동 매핑됨.
	}
	
//	@RequestMapping(value = "/insertDept", method =RequestMethod.POST)
	@PostMapping("/insertDept")
	public ModelAndView insertSubmit(DeptVO d) { // vo에 알아서 담아줌 !! 
		int re = dao.insert(d);
		ModelAndView mav = new ModelAndView("insertDeptOK");
		String msg = "부서 등록 성공~"; // 기본값 
		if(re != 1) {
			msg = "부서 등록 실패 ! ";
		}
		mav.addObject("msg",msg);
		return mav;
	}
	
	@RequestMapping("/listDept")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.findAll()); // 상태유지 ! 
		mav.setViewName("listDept");
		return mav;
	}
}
