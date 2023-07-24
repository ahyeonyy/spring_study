package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.vo.CustomerVO;

import lombok.Setter;

@Service
@Setter
public class CustomerService {
	@Autowired
	CustomerDAO dao;
	
	public List<CustomerVO> findAll(){
		return dao.findAll();
	}
	public void save(CustomerVO c) {
		dao.save(c);
	}
	public CustomerVO getOne(int bookid) {
		return dao.getById(bookid);
	}
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}
}
