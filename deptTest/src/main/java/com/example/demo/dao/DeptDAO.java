package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.DeptVO;

@Repository
public class DeptDAO {
	public ArrayList<DeptVO> findAll(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##madang","madang");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// 자바 객체를 데이터베이스 테이블에 매핑
			// 데이터베이스 테이블을 자바 객체에 매핑
			// Object Relation Mapping
			// ORM
			// mybatis, hibernate
			// DataJPA
			while(rs.next()) {
				DeptVO d = new DeptVO();
				d.setDno(rs.getInt(1));
				d.setDname(rs.getString(2));
				d.setDloc(rs.getString(3));
				list.add(d);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return list;
	}
	
}
