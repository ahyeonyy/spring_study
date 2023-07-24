package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "view_listorders")
public class View_ListOrders {
	@Id
	private int orderid;
	private String name;
	private String bookname;
	private String orderdate;
	private int saleprice;
	private int price;
}
