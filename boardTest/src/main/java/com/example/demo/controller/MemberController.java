package com.example.demo.controller;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import jakarta.servlet.http.HttpSession;
import kr.co.youiwe.webservice.BitSms;
import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MailSender mailSender;
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("/validCheck")
	@ResponseBody
	public String validCheck(String to, String authType) {
		String data = "";
		Random r =  new Random();
		data = r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10)+"";
		
		if(authType.equals("email")) {
			SimpleMailMessage mailMessage
			= new SimpleMailMessage();
			mailMessage.setFrom("qlqlql8448@gmail.com");
			mailMessage.setTo(to);
			mailMessage.setSubject("인증번호를 발송합니다.");
			mailMessage.setText(data);
			try {
				mailSender.send(mailMessage);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}else {
			String from = "01025598279";
			String msg = data;
			BitSms.sendMsg(from, to, msg);
		}
		
		return data;
	}
	
	
	@GetMapping("/validEmail")
	@ResponseBody
	public String validEmail(String email) {
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		String data = a+""+b+""+c+""+d;
		SimpleMailMessage mailMessage
		= new SimpleMailMessage();
		mailMessage.setFrom("qlqlql8448@gmail.com");
		mailMessage.setTo(email);
		mailMessage.setSubject("인증번호를 발송합니다.");
		mailMessage.setText(data);
		try {
			mailSender.send(mailMessage);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
		return data;
	}
	@GetMapping("/validPhone")
	@ResponseBody
	public String validPhone(String phone) {
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		String data = a+""+b+""+c+""+d;
		String from = "01025598279";
		String to = phone;
		String msg = data;
		BitSms.sendMsg(from, to, msg);
		return data;
	}
	
	
	@PostMapping("/insertMember")
	public ModelAndView insertMemberSubmit(MemberVO m) {
		ModelAndView mav = new ModelAndView("redirect:/login");
		try {
			int re = dao.insertMember(m);
			if(re == 1) {
				mav.addObject("msg", m.getName()+"님 환영합니다 ! ");
			}else {
				mav.addObject("msg", "회원가입 실패 @!");
				mav.setViewName("error");
			}
		} catch (Exception e) {
			mav.addObject("msg", e.getMessage());
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	@PostMapping("/login")
	public ModelAndView loginOK(String id, String pwd, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/listboard");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pwd", pwd);
		if(dao.login(map)) {
			session.setAttribute("id", id);
			mav.setViewName("redirect:/listboard");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	@GetMapping("/join2")
	public void joinForm() {		
	}
}









