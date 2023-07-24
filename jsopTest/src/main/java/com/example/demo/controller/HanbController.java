package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.NewBook;

@RestController
public class HanbController {
	
	@GetMapping("/allImg")
	public String allImg() {
		String  addr = "https://www.hanbit.co.kr/store/books/new_book_list.html";
		try {
			Document doc = Jsoup.connect(addr).get();
//			Elements list = doc.select("#container > div.new_book_list_wrap > div.sub_book_list_area ");
		Elements list = 	doc.getElementsByClass("thumb");
			System.out.println("list : "+list);
			
			for(Element e :list) {

					String link = "https://www.hanbit.co.kr"+e.attr("src");
					String fname = "image"+System.currentTimeMillis();
//					System.out.println("link:"+link);
					URL url = new URL(link);
					InputStream is = url.openStream();
					FileOutputStream fos = new FileOutputStream("/Users/ahyeonlee/Desktop/data/"+fname+".jpg");
					FileCopyUtils.copy(is.readAllBytes(),fos);
					System.out.println("이미지 다운로드 ! ");

			
			}
			
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
//		String select = "#container > div.new_book_list_wrap > div.sub_book_list_area>sub_book_list>view_box";
		return "OK";
	}
	
	@GetMapping("/downImg")
	public String downImg() {
		String addr = "https://www.hanbit.co.kr/data/books/B2151756581_m.jpg";
		String fname = "숨은그림찾기";
		try {
			URL url = new URL(addr);
			InputStream is = url.openStream();
			FileOutputStream fos = new FileOutputStream("/Users/ahyeonlee/Desktop/data/"+fname+".jpg");
			FileCopyUtils.copy(is.readAllBytes(),fos);
			is.close();
			fos.close();
			System.err.println("이미지 다운로드 ! ");
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return "OK";
	}
	
	
	@GetMapping("/newBook")
	public ArrayList<NewBook> newBook(){
		ArrayList<NewBook> arr = new ArrayList<NewBook>();
		String url = "https://www.hanbit.co.kr/store/books/new_book_list.html";
		try {
			Document doc = Jsoup.connect(url).get();
			ArrayList<String> json = new ArrayList<String>();
			//클래스가 book_tit 인것 가져오기
			Elements list = doc.getElementsByClass("book_tit");
			for(Element e :list) {
				 Element a = e.getElementsByTag("a").get(0);
				 String title = a.text();
				 String link = "https://www.hanbit.co.kr"+a.attr("href");
				 arr.add(new NewBook(title,link));
			}
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return arr;
	}
	
	@GetMapping("/seat")
	public String seat_info() {
		String seat = "";
		String url = "http://mpllc-seat.sen.go.kr/seatinfo/Seat_Info/1_count.asp";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements info = doc.getElementsByClass("wating_f");
			seat = info.get(0).text();
		} catch (Exception e) {
			System.out.println("예외발생 :"+e.getMessage());
		}
		
		return seat;
	}
}
















