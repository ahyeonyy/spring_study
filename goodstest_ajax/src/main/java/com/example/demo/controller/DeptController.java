package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

import lombok.Setter;

@RestController //@Controller + @ResponseBody
@Setter
public class DeptController {

	@Autowired
	private DeptDAO dao;
	
	@GetMapping("/listDept")
	public List<DeptVO> findDept(){
		return dao.findDept();
	}
}
