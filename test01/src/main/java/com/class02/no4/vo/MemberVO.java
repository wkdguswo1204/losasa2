package com.class02.no4.vo;

import java.sql.*;
import java.text.*;

public class MemberVO {
	private int mno, ano;
	private String name, id, pw, mail, gen, tel, joindate;
	private Date sdate;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.joindate = form1.format(sdate);
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	
	
}
