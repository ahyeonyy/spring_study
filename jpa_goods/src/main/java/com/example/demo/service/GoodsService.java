package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import lombok.Setter;

@Service
@Setter
public class GoodsService {
	@Autowired
	private GoodsDAO dao;

	public List<GoodsVO> findAll(){
		return dao.findAll();
	}
	// 새로운 레코드를 추가하거나 수정할때 하나의 메소드를 이용 
	// 만약 pk가 이미 있으면 수정해주고 없으면 추가 
	public void save(GoodsVO g) {
		dao.save(g);
	}
	
	//상세보기나, 수정할때에 pk를 매개변수로 전달받아
	//해당 레코드를 반환하는 메소드 getOne
	public GoodsVO getOne(int no) {
		return dao.getById(no);
	}
	public void delete(int no) {
		 dao.deleteById(no);
	}
}














