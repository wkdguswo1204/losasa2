package losasa2.VO;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class LosVO {
	private int mno, msg;
	private String name, admin, ldate;
	private Date sdate;
	private Time stime;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getMsg() {
		return msg;
	}
	public void setMsg(int msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getLdate() {
		return ldate;
	}
	public void setLdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.ldate = form1.format(sdate) + " " + form2.format(stime);
	}
	public void setLdate(String ldate) {
		this.ldate = ldate;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Time getStime() {
		return stime;
	}
	public void setStime(Time stime) {
		this.stime = stime;
	}
	
	
}
