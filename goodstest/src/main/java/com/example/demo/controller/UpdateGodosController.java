package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/updategoods")
public class UpdateGodosController {

	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void updateForm(int no,Model model) {
		model.addAttribute("g", dao.detailGoods(no));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView updateSubmit(GoodsVO g, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listgoods");
		String path = request.getServletContext().getRealPath("images");
		String oldFname = g.getFname();
		
		MultipartFile uploadFile = g.getUploadFile();
		String fname = null;
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			// 중복된 파일명을 피하기 위해 임의의 난수를 발행하여 파일명 뒤에 붙여줌.
			long n = System.currentTimeMillis();
			fname = fname.replace(".",",");
			String []str = fname.split(",");
//			System.out.println(str);
			fname = str[0] + n + "."+str[1];
			g.setFname(fname);
		}
		
		try {
			int re = dao.update(g);
			// 수정에 성공했고 파일도 수정했다면 원래 파일은 삭제하도록 함
			if(re ==1 && fname!= null && !fname.equals("")  ) {
				File file = new File(path+"/"+oldFname);
				file.delete();
				try {
					byte []data = uploadFile.getBytes();
					FileOutputStream fos = new FileOutputStream(path+"/"+fname);
					fos.write(data);
					fos.close();
				} catch (Exception e) {
					System.out.println("예외발생 : "+e.getMessage());
				}
			}
			
		} catch (Exception e) {
			mav.addObject("msg",e.getMessage());
			mav.setViewName("error");
		}
		return mav;
	}
}



















