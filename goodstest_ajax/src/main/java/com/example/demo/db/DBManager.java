package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVO;
import com.example.demo.vo.GoodsVO;

public class DBManager {
	public static SqlSessionFactory sqlSessionFactory ;
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
	public static List<DeptVO> findDept(){
		List<DeptVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("dept.findDept");
		session.close();
		return list;
	};
	public static int insert(GoodsVO g) {
		int re= -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.insert("goods.insert", g);
		session.commit();
		session.close();
		return re;
	}
	public static int delete(int no) {
		int re= -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.delete("goods.delete", no);
		session.commit();
		session.close();
		return re;
	}
	public static int update(GoodsVO g) {
		int re= -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.update("goods.update", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static GoodsVO detailGoods(int no) {
		SqlSession session = sqlSessionFactory.openSession();
		GoodsVO g = session.selectOne("goods.detailGoods", no);
		session.close();
		return g;
	}
	
	public static List<GoodsVO> findAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<GoodsVO> list = session.selectList("goods.findAll");
		session.close();
		return list;
	}
}















