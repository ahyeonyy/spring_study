package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.View_ListOrders;

@Repository
public interface View_ListOrdersDAO extends JpaRepository<View_ListOrders, Integer> {
	public List<View_ListOrders> findByNameLikeOrderByOrderid(String keyword);

	public List<View_ListOrders> findByNameLikeOrderByName(String name);

	public List<View_ListOrders> findByNameLikeOrderByBookname(String name);

	public List<View_ListOrders> findByNameLikeOrderByOrderdate(String name);

	public List<View_ListOrders> findByNameLikeOrderBySaleprice(String name);

	public List<View_ListOrders> findByNameLikeOrderByPrice(String name);

	public List<View_ListOrders> findByBooknameLikeOrderByOrderid(String keyword);

	public List<View_ListOrders> findByBooknameLikeOrderByName(String bookname);

	public List<View_ListOrders> findByBooknameLikeOrderByBookname(String bookname);

	public List<View_ListOrders> findByBooknameLikeOrderByOrderdate(String bookname);

	public List<View_ListOrders> findByBooknameLikeOrderBySaleprice(String bookname);

	public List<View_ListOrders> findByBooknameLikeOrderByPrice(String bookname);

	public List<View_ListOrders> findAllByOrderByOrderid();

	public List<View_ListOrders> findAllByOrderByName();

	public List<View_ListOrders> findAllByOrderByBookname();

	public List<View_ListOrders> findAllByOrderByOrderdate();

	public List<View_ListOrders> findAllByOrderBySaleprice();

	public List<View_ListOrders> findAllByOrderByPrice();
}
