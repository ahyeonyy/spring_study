package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "board")
public class Board {
	
	@Id
	private int no;
	private String title;
	private String writer;
	private String pwd;
	private String content;
	private String regdate;
	private int hit;
	private String fname;
	
	// 데이터베이스 테이블 매핑에서는 제외시켜랏 ! 
	@Transient
	private MultipartFile uploadFile;
	
	private int b_ref;
	private int b_level;
	private int b_step;
}















