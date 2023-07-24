package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BoardDAO;
import com.example.demo.entity.Board;

import lombok.Setter;

@Service
@Setter
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	// 전체 레코드 수를 반환하는 메소드 정의 
	public int getTotalRecord() {
		return (int)dao.count(); 
	}
	public void save(Board b) {
		dao.save(b);
	}
	public int deleteBoard(int no, String pwd) {
		return dao.deleteBoard(no, pwd);
	}
	
	public List<Board> findAll(int start, int end){
		return dao.selectAll(start,end);
		
	}
	public int getNo() {
		return dao.getNo();
	}
	public List<Board> findByWriter(String writer) {
		return dao.findByWriter(writer);
	}
	public void insert(Board b) {
		dao.insert(b);
	}
	public Board findById(int no) {
		return dao.findById(no).get();
	}
	public void updateStep(int b_ref, int b_step) {
		dao.updateStep(b_ref, b_step);
	}
}
