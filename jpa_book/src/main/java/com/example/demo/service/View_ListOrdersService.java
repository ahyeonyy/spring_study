package com.example.demo.service;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.View_ListOrdersDAO;
import com.example.demo.vo.View_ListOrders;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Service
@Setter
public class View_ListOrdersService {
	@Autowired
	private View_ListOrdersDAO dao;

	public List<View_ListOrders> findAll(String column, String keyword, String sort) {
	
		List<View_ListOrders> list = null;
		System.out.println(sort);
		try {
			Class<?> cls = Class.forName(dao.getClass().getName());
			String methodName = "find";
			if (keyword != null && !keyword.equals("")) {
				methodName += "By" + column;
				if (sort != null && !sort.equals("")) {
					methodName += "LikeOrderBy" + sort;
				} else {
					methodName += "LikeOrderByOrderid";
				}
				Method m = cls.getDeclaredMethod(methodName, String.class); // Integer.class는 메소드 매개변수의 자료형
				list = (List<View_ListOrders>) m.invoke(dao, "%"+keyword+"%");

			} else {
				methodName += "AllByOrderBy";
				if (sort != null && !sort.equals("")) {
					methodName += sort;
				} else {
					methodName += "Orderid";
				}
				Method m1 = cls.getDeclaredMethod(methodName); // Integer.class는 메소드 매개변수의 자료형
				list = (List<View_ListOrders>) m1.invoke(dao);
			}
			System.out.println("메소드이름 : " + methodName);


		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		return list;

	}
}
