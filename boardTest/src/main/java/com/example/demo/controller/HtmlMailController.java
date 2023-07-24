package com.example.demo.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.EmpVO;

import lombok.Setter;

@Controller
@Setter
public class HtmlMailController {
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	EmpDAO dao;
	
	public String maskTable(EmpVO e) {
		String table = "";
		
		table = "<h2>"+e.getEname()+"님의 급여 명세서</h2>"
				+ "<hr>"
				+ "<table>"
				+ "<tr><th>이름</th><th>급여</th><th>수당</th><th>실수령액</th></tr>"
				+ "<tr>"
				+ "<td>"+e.getEname()+"</td>"
				+ "<td>"+e.getSalary()+"</td>"
				+ "<td>"+e.getComm()+"</td>"
				+ "<td>"+e.getSalary()+e.getComm()+"</td>"
				+ "</tr>"
				+ "</table>";
		
		return table;
	}
	
	
	
	@GetMapping("/sendHtmlEmail")
	@ResponseBody
	public String send() {
		sender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = 
						new MimeMessageHelper(mimeMessage, "utf-8");
				List<EmpVO> list = dao.salary();
				
				for(EmpVO e : list) {
					message.setFrom("qlqlql8448@gmail.com");
					message.setTo(e.getEmail());
					message.setSubject(e.getEname()+"님 급여 명세서 [담당자 : 이아현]");
					String table = "<h2>"+e.getEname()+"님의 급여 명세서</h2>"
							+ "<hr>"
							+ "<table>"
							+ "<tr><th>이름</th><th>급여</th><th>수당</th><th>실수령액</th></tr>"
							+ "<tr>"
							+ "<td>"+e.getEname()+"</td>"
							+ "<td>"+e.getSalary()+"</td>"
							+ "<td>"+e.getComm()+"</td>"
							+ "<td>"+e.getSalary()+e.getComm()+"</td>"
							+ "</tr>"
							+ "</table>";
					message.setText(table,true); // true : html 형태로 보낸다~ 
					
				}
						
			}
		});
		return "ok";
	}
}
