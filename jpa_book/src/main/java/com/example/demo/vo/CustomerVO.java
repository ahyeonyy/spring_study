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
@Table(name="customer")
public class CustomerVO {
	@Id
	private int custid;
	private String name;
	private String addr;
	private String phone;
	private String fname;
	
	@OneToMany(mappedBy = "customer", fetch=FetchType.EAGER) //즉시로딩
	private List<OrdersVO> orders;
}
