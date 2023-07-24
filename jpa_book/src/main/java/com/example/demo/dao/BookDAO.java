package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.BookVO;

@Repository
public interface BookDAO extends JpaRepository<BookVO, Integer>{
//	public List<BookVO> findAllOrderByBookid(int bookid);
	@Query("select b from BookVO b order by b.bookid")
	public List<BookVO> findAllByOrderByBookname();
	
	public List<BookVO> findByBooknameLikeOrderByBookidDesc( String keyword);

	public List<BookVO> findByBookidLikeOrderByBookidDesc(String keyword);

	public List<BookVO> findByPublisherLikeOrderByBookidDesc(String keyword);

	public List<BookVO> findByPriceLikeOrderByBookidDesc(String keyword);
}
