package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class BoardController {
	public int pageSize = 10;
	public int totalRecord;
	public int totalPage;
	 
	 
	
	@Autowired
	private BoardService bs;
	
	@Autowired
	private MemberDAO memberdao;
	
	@GetMapping(value={"/board/list/{pageNUM}"})
	public String list(Model model,@PathVariable("pageNUM") int pageNUM, HttpSession session,String writer){
		
		//로그인한 회원의 상태유지 - 세션 사용
		
		// 로그인한 회원의 정보를 가져오기 위해 authentication 객체 생성  
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// authenticatio 객체를 통해서 로그인한 회원의 정보를 가져옴
		 User user = (User)authentication.getPrincipal();
		 
		 // user를 통해서 로그인한 회원의 아이디를 가져옴
		 String loginId = user.getUsername();
		 
//		  아이디만 상태유지할 수도 있고 dao를 통해서 회원 객체를 가져와 그것을 상태유지할 수도 있음.
		session.setAttribute("user", memberdao.findById(loginId).get()); 
//		session.setAttribute("id", loginId);
		
		totalRecord = bs.getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
//		System.out.println("totalRecord:"+totalRecord);
//		System.out.println("totalPage:"+totalPage);
//		System.out.println("현재페이지:"+pageNUM);
		int start = (pageNUM-1)*pageSize +1;
		int end = start + pageSize-1;
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		
		if(writer != null && !writer.equals("")) {
			model.addAttribute("list",bs.findByWriter(writer));
		}else {
			model.addAttribute("list",bs.findAll(start,end));
		}
		model.addAttribute("totalPage",totalPage);
		return "board/list";
	}
	
	@PostMapping("/board/delete")
	public ModelAndView delete(int no, String pwd, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/board/list/1");
		String path = request.getServletContext().getRealPath("/images");
		String fname = bs.findById(no).getFname();
		if(bs.deleteBoard(no, pwd) == 1) {
			if(fname != null && !fname.equals("")) {
				File file = new File(path+"/"+fname);
				file.delete();
			}
		}
		return mav;
	}
	
	@RequestMapping("/board/save")
	public ModelAndView save(Board b, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/images");
		System.out.println("paht:"+path);
		String fname = null;
		MultipartFile uploadFile = b.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				FileCopyUtils.copy(uploadFile.getBytes(),fos);
				fos.close();
			} catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}else {
			fname="";
		}
		b.setFname(fname);
		ModelAndView mav = new ModelAndView("redirect:/board/list/1");
		Date today = new Date();
		System.out.println(today.toString());
		int no = bs.getNo();
		int b_ref = no;
		int b_level = 0;
		int b_step=0;
		
		//답글에 대한 처리
		int pno = b.getNo();
		if(pno != 0) {
			Board p = bs.findById(pno);
			b_ref = p.getB_ref();
			b_level=p.getB_level();
			b_step= p.getB_step();
			bs.updateStep(b_ref, b_step);
			b_level++;
			b_step++;
		}
		
		b.setHit(0);
		b.setNo(no);
		b.setB_level(b_level);
		b.setB_ref(b_ref);
		b.setB_step(b_step);
		bs.insert(b);
		return mav;
	}
	
	@GetMapping("/board/delete/{no}")
	public String delete(@PathVariable("no") int no, Model model) {
		model.addAttribute("no",no);
		return "/board/delete";
	}
	

	
	@GetMapping("/board/detail/{no}")
	public ModelAndView detail(@PathVariable("no") int no) {
		System.out.println("글번호 : "+no);
		ModelAndView mav = new ModelAndView("/board/detail");
		mav.addObject("b", bs.findById(no));
		return mav;
	}
	
	@GetMapping("/board/insert/{no}")
	public String insert(@PathVariable(required = false) int no,Model model) {
		model.addAttribute("no",no);
		return "/board/insert";
	}
}
