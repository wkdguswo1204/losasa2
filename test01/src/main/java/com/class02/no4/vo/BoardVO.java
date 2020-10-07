package com.class02.no4.vo;

import java.sql.*;
import java.text.*;

public class BoardVO {
	private int rno, ano, bno, bino, mno, click, bmno;

	private String id, title, body, name, oriname, savename, sdate;
	private Date bdate;
	private Time btime;
	/* private ProfileVO fVO; */
	
	public int getBmno() {
		return bmno;
	}
	public void setBmno(int bmno) {
		this.bmno = bmno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		this.sdate = new SimpleDateFormat("yyyy/MM/dd").format(bdate) + new SimpleDateFormat(" HH:mm:ss").format(btime);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public Time getBtime() {
		return btime;
	}
	public void setBtime(Time btime) {
		this.btime = btime;
		setSdate();
	}
	public int getBino() {
		return bino;
	}
	public void setBino(int bino) {
		this.bino = bino;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	
	@Override
	public String toString() {
		return "BoardVO [rno=" + rno + ", ano=" + ano + ", bno=" + bno + ", mno=" + mno + ", click=" + click + ", id="
				+ id + ", title=" + title + ", body=" + body + ", sdate=" + sdate + ", bdate=" + bdate + ", btime="
				+ btime + "]";
	}
}
