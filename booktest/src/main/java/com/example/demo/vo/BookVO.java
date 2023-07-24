package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookVO {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
}
