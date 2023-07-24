package com.example.demo.vo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class BookVO {
	
	@Id
	private int bookid;
	private String bookname;
	private int price;
	private String publisher;
	
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER) //즉시 읽어와~ 넹~
	private List<OrdersVO> orders;
}
