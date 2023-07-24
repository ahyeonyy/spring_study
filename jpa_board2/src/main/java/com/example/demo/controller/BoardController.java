package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@Controller
@Setter
public class BoardController {
	public int pageSize = 10;
	public int totalRecord;
	public int totalPage;
	 
	 
	
	@Autowired
	private BoardService bs;
	
	@GetMapping("/board/list/{pageNUM}")
	public String list(Model model,@PathVariable("pageNUM") int pageNUM){
		totalRecord = bs.getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
		System.out.println("totalRecord:"+totalRecord);
		System.out.println("totalPage:"+totalPage);
		System.out.println("현재페이지:"+pageNUM);
		int start = (pageNUM-1)*pageSize +1;
		int end = start + pageSize-1;
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		model.addAttribute("list",bs.findAll(start,end));
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
	
	@PostMapping("/board/delete")
	public ModelAndView delete(int no, String pwd, HttpRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/board/list/1");
		return mav;
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
