package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVO;

@Repository
public class MemberDAO {
	public int insert(MemberVO m) {
		return DBManager.insert(m);
	}
	public MemberVO findById(String id) {
		return DBManager.findById(id);
	}
}
