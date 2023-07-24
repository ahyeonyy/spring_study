package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data

@Table(name = "goods")
public class GoodsVO {
	@Id
	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname;
}