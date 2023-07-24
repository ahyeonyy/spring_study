package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersDAO;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.OrdersVO;

import lombok.Setter;

@Service
@Setter
public class OrdersService {
	@Autowired
	private OrdersDAO dao;
	public int getNextNo() {
		return dao.getNextNO();
	}
	public void insert(OrdersVO o) {
		dao.insert(o);
	}
	public List<OrdersVO> list(){
		return dao.findAllByOrderByOrderid();
	}
}
