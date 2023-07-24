package com.example.demo.util;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.EmpVO;

import lombok.Setter;

@Setter
@Component
@EnableScheduling
public class SistUtil {
//	@Scheduled(fixedRate = 10000)
	@Scheduled(cron = "50 10 11 * * ?")
	public void pro() {
		System.out.println("콜콜!");
	}

	@Autowired
	private MailSender mailSender;
	@Autowired
	private EmpDAO dao;
	@Autowired
	private JavaMailSender sender;

//	@Scheduled(cron = "30 40 11 * * ?")
	public void salary() {
		List<EmpVO> list = dao.salary();
		for (EmpVO e : list) {
			String name = e.getEname();
			String email = e.getEmail();
			int salary = e.getSalary();
			int comm = e.getComm();
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setFrom("qlqlql8448@gmail.com");
			mailMessage.setSubject(name + "님 이번달 급여 명세서 [담당자 : 이아현]");
			mailMessage.setText(name + "님 이번달 급여는 " + salary + " + " + comm + " = " + (salary + comm) + "입니다.");
			mailSender.send(mailMessage);
			System.out.println("전송완료");
		}
	}

//	@Scheduled(cron = "30 20 14 * * ?")
	public void send() {
		List<EmpVO> list = dao.salary();
		for (EmpVO e : list) {
			sender.send(new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");

					message.setFrom("qlqlql8448@gmail.com");
					message.setTo(e.getEmail());
					message.setSubject(e.getEname() + "님 급여 명세서 [담당자 : 이아현]");
					int total= e.getComm()+e.getSalary();
					String table = "<h2>" + e.getEname() + "님의 급여 명세서</h2>" + "<hr>" + "<table>"
							+ "<tr><th>이름</th><th>급여</th><th>수당</th><th>실수령액</th></tr>" + "<tr>" + "<td>" + e.getEname()
							+ "</td>" + "<td>" + e.getSalary() + "</td>" + "<td>" + e.getComm() + "</td>" + "<td>"
							+ total + "</td>" + "</tr>" + "</table>";
					message.setText(table, true); // true : html 형태로 보낸다~
					System.out.println(e.getEname() + "전송완료 ");

				}
			});
		}
	}
}
