package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class SmsController {

	@ResponseBody
	@GetMapping("/sendMessage")
	public String sendMessage() {
		String from = "01025598279";
		String to = "01050048448";
		String msg = "우주최강김덗두";
		BitSms.sendMsg(from, to, msg);
		return "OK";
	}
}
