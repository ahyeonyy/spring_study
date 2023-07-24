package com.example.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;


@Setter
@RequestMapping("/deleteBoard")
@Controller
public class DeleteController {
@Autowired
private BoardDAO dao;

@RequestMapping(method=RequestMethod.GET)
public void form(Model model , int no) {
	model.addAttribute("b", dao.findByNo(no));
}

@RequestMapping(method=RequestMethod.POST)
public ModelAndView submit(BoardVO b, HttpServletRequest request) {
	String path = request.getServletContext().getRealPath("upload");
	System.out.println(path);
	ModelAndView mav = new ModelAndView("redirect:/listboard");
	try {
		int re = dao.delete(b);
		if(re ==1 ) {
			File file = new File(path+"/"+b.getFname());
			file.delete();
		}
	} catch (Exception e) {
		mav.addObject("msg", e.getMessage());
	}
	return mav;
}

}















