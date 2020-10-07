package com.class02.no4.util;
/**
 * 이 클래스는 메일 발송담당 클래스
 * @author 임서진
 * @since 2020.07.01
 * @see /no4/controller/member/member/mailCk.no4
 */

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
	private Session session;
	private String host;
	private String user;
	private String pass;
	private String domain;
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	private Properties prop = new Properties();
	public boolean mailInit() {
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", host);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.debug", "true");
		session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(user, pass);
		}
		});
		return true;
	}
	
	// 메일 발송 전담 함수
	public int getSend(String from, String title, String mtxt) {
		mailInit();
		
		int cnt = 0;
		String getFrom = from;
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(user));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(getFrom));
			msg.setSubject(title); // 메일 제목
			msg.setContent(mtxt, "text/html;charset=UTF-8"); // 메일 본문
			
			Transport.send(msg);
			cnt = 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
