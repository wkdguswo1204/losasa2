package com.class02.no4.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.ResponseBody;

import com.class02.no4.dao.*;
import com.class02.no4.util.*;
import com.class02.no4.vo.*;

@Service
public class MemberService {
	@Autowired
	MemberDAO mDAO;
	@Autowired
	MailUtil no4;
	@Autowired
	JoinMailDAO jDAO;
	
	// 임시 비밀번호 발급 처리 함수
	public String setPassword(int length) {
		int index = 0;
		char[] charArr = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' ,'!','@','-','_','$','*'};
		
		StringBuffer buff = new StringBuffer();
		for(int i = 0; i < length; i++) {
			index = (int) (charArr.length * Math.random());
			buff.append(charArr[index]);
		}
		return buff.toString();
	}
	
	// 임시 비밀번호 이메일 보내기 함수
	public HashMap<String, String> pwfind(String mail, String id, MemberVO mVO){
		String from = mail;
		mVO.setId(id);
		id = mVO.getId();
		// 임시 비번 생성
		String pw = setPassword(8);
		//임시 비번 DB저장
		mVO.setPw(pw);
		mDAO.pwchange(mVO);
		int cnt = 0;
		
		HashMap<String, String> map = new HashMap<String, String>();
		cnt = mDAO.pwfind(mVO);
		
		if(cnt == 0) {
			map.put("result", "no");
		} else {
			map.put("result", "ok");
			String title = "고객님의 계정 임시 비밀번호 패스워드 발송 안내입니다.";
			StringBuffer mtxt = new StringBuffer();
			mtxt.append("<h2>반갑습니다. <b>YummyMap</b> 입니다.</h2> ");
			mtxt.append("<br> ");
			mtxt.append("<h3>고객님의 임시 비밀번호는 : <b style=\"color: blue;\">"+pw+"</b> 입니다.</h3> ");
			mtxt.append("<br> ");
			mtxt.append("<h3>로그인후 반드시 패스워드 변경 부탁드립니다. </h3> ");
			mtxt.append("<h3>감사합니다.</h3> ");
			
			no4.getSend(from, title, mtxt.toString());
		}
		return map;
	}
	// 아이디 찾기 이메일 함수
	public HashMap<String, String> idfind(String mail, String id, MemberVO mVO){
		String from = mail;
		id = mDAO.idfind(mVO);
		HashMap<String, String> map = new HashMap<String, String>();
		if(id == null) {
			map.put("result", "no");
		} else {
			map.put("result", "ok");
			
			String title = "아이디 찾기 메일입니다.";
			StringBuffer mtxt = new StringBuffer();
			mtxt.append("<h2>반갑습니다. <b>YummyMap</b> 입니다.</h2> ");
			mtxt.append("<br> ");
			mtxt.append("<h3>요청 주신 ID는 <b style=\"color: blue;\">"+ id +"</b> 입니다.</h3> ");
			mtxt.append("<br> ");
			mtxt.append("<h3>감사합니다.</h3> ");
			
				no4.getSend(from, title, mtxt.toString());
		}
		return map;
	}
	// 인증메일 보내기 함수
	
	public @ResponseBody String mailCk(JoinMailVO jVO) {
		String from = jVO.getMail();
		// 인증번호 생성
		Random ran = new Random();
		StringBuffer buff = new StringBuffer();
		for(int i = 0; i < 6; i++) {
			buff.append(ran.nextInt(10));
		}
		// 이메일 보내기
		String inck = buff.toString();
		String title = "no4 이메일 인증 메일입니다.";
		StringBuffer mtxt = new StringBuffer();
		mtxt.append("<h2>반갑습니다. <b>YummyMap</b> 입니다.</h2> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>요청 주신 인증 번호는 <b style=\"color: blue;\">"+inck+"</b> 입니다.</h3> ");
		mtxt.append("<br> ");
		mtxt.append("<h3>인증 번호 입력 란에 입력해주시고 인증 확인후 진행 부탁드립니다</h3> ");
		mtxt.append("<h3>감사합니다.</h3> ");
		
			no4.getSend(from, title, mtxt.toString());
			String inmail = inck;
			int num = Integer.parseInt(inck);
			jVO.setCftnum(num);
			int cnt = jDAO.mailCnt(jVO);
			if(cnt != 0) {
				jDAO.mailUp(jVO);
			} else if(cnt == 0) {
				jDAO.newMail(jVO);
			}
		return inmail;
	}
	
	// 인증확인 함수
	
	public @ResponseBody HashMap<String, String> mailNum(JoinMailVO jVO, HttpServletRequest req) {
		HashMap<String, String> map = new HashMap<String, String>();
		int num = jVO.getCftnum();
		String mailobefore = req.getParameter("cftnum");
		int mailoafter = Integer.parseInt(mailobefore);
		if(num == mailoafter) {
			map.put("result", "ok");
		} else {
			map.put("result", "no");
		}
		return map;
	}
}