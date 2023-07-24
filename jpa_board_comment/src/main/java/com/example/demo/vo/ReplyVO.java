package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	 int cno;
	 int b_level;
	 int b_step;
	 int b_ref;
	 Date regdate;
	 String id;
	 String content;
}
