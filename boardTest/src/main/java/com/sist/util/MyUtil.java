package com.sist.util;

import com.example.demo.vo.EmpVO;

public class MyUtil {
	public static String getHtml(EmpVO e) {
		String str = "";
		int total= e.getComm()+e.getSalary();
		str +="<h2>" + e.getEname() + "님의 급여 명세서</h2>"
		+ "<hr>" 
		+ "<table>"
		+ "<tr><th>이름</th><th>급여</th><th>수당</th><th>실수령액</th></tr>" + "<tr>" + "<td>" + e.getEname()
		+ "</td>" + "<td>" + e.getSalary() + "</td>" + "<td>" + e.getComm() + "</td>" + "<td>"
		+ total + "</td>" + "</tr>" 
		+ "</table>";
		
		return str;
	}
	
	
	public static String getRenameNotMultiple(String oldName) {
		String fname =  "";
//		oldName.replace(".", ",");
		String []arr = oldName.split("\\.");
		try {
			long n = System.currentTimeMillis();
			fname = arr[0] + n +"."+arr[1];
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return fname;
	}
}
