package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import lombok.Setter;

@Service
@Setter
public class BookService {
	
	@Autowired
	private BookDAO dao;
	
	public List<BookVO> findAll(String searchColumn, String keyword){
		if(keyword != null && !keyword.equals("")) {
			if(searchColumn.equals("bookid")) {
				return dao.findByBookidLikeOrderByBookidDesc("%"+keyword+"%");							
			}else if(searchColumn.equals("bookname")) {
				return dao.findByBooknameLikeOrderByBookidDesc("%"+keyword+"%");							
				
			}else if (searchColumn.equals("publisher")) {
				return dao.findByPublisherLikeOrderByBookidDesc("%"+keyword+"%");							
			}else if (searchColumn.equals("price")){
				return dao.findByPriceLikeOrderByBookidDesc("%"+keyword+"%");											
			}
		}
		System.out.println("searchColumn:"+searchColumn);
		System.out.println("keyword:"+keyword);
		return dao.findAllByOrderByBookname();
	}
	
	public BookVO getOne(int bookid) {
		return dao.getOne(bookid);
	}
	
	public void save(BookVO b) {
		dao.save(b);
	}
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}
	

}
