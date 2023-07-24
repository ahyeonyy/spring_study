package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchClientAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/insertgoods")
public class InsertGoodsController {

	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(GoodsVO g, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listgoods");
		String path = request.getServletContext().getRealPath("images");
		System.out.println(path);

		MultipartFile uploadFile = g.getUploadFile();

		// 일단 파일 명에 ""을 설정함
		String fname = null;

		// 업로드한 파일명을 fname 변수에 저장
		fname = uploadFile.getOriginalFilename();

		// 만약 업로드파일이 있다면
		if (fname != null && !fname.equals("")) {
			long n = System.currentTimeMillis();
			fname = fname.replace(".", ",");
			String[] str = fname.split(",");
//			System.out.println(str);
			fname = str[0] + n + "." + str[1];

		}
		// 업로드한 파일 명이 있다면 그 파일명을 설정
		g.setFname(fname);
		try {

			int re = dao.insert(g);
			if (re == 1) {
				try {
					// 파일의 내용을 바이트로 가져옴
					byte[] data = uploadFile.getBytes();

					// 파일을 출력하기 위한 스트림 생성
					FileOutputStream fos = new FileOutputStream(path + "/" + fname);

					// 파일에 출력
					fos.write(data);
					fos.close();

				} catch (Exception e) {
					System.out.println("예외발생 : " + e.getMessage());
				}
			}
		} catch (Exception e) {
			/*
			 * File file = new File(path+"/"+fname); file.delete();
			 */
			mav.addObject("msg", "상품 등록 실패!");
			mav.setViewName("error");
		}
		return mav;
	}
}
