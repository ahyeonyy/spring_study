package com.example.demo.vo;

import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class DeptVO {
	private int dno;
	private String dname;
	private String dloc;
	
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	
}
