package com.class02.no4.controller.member;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.class02.no4.dao.*;
import com.class02.no4.service.*;
import com.class02.no4.util.*;
import com.class02.no4.vo.*;




// 테스트

import java.util.Optional;
import org.springframework.util.Assert;

// 테스트 끝

@Controller
@RequestMapping("/member")
public class Member {
	
	@Autowired
	MemberDAO mDAO;
	@Autowired
	MemberService mSrvc;
	
	// 로그인 화면
	@RequestMapping("/signin.no4") // /member/signin.no4를 매핑한다
	public ModelAndView signin(ModelAndView mv) {
		System.out.println("asdfsdfsadffdfsdf");
		/*
		 	signin이라는 처리함수를 만드는데 배개변수는 modelandview를 사용함으로써
		 	뷰를 전달할 수 잇게끔 한다.
		 */
		String view = "member/signin";
		mv.setViewName(view);
		return mv;
	}

	// 파라미터에 아이디가 없는 경우의 SignProc 리다이렉트 처리 함수
	
	@RequestMapping(value="/SigninProc", method=RequestMethod.POST, params={"!id"}) public ModelAndView signinProcRedirect(ModelAndView mv, String id, String pw) {

	RedirectView rv = new RedirectView("/signin.no4"); return mv;
	}

	// 파라미터에 아이디가 있는 경우의 SignProc 로그인 처리 함수

	@RequestMapping(value="/signinProc", method=RequestMethod.POST, params=
	{"id", "pw"}) public ModelAndView signinProc(String id, String pw, MemberVO mVO, ModelAndView mv, HttpSession session) {
		// 아이디와 pw 값 얻고
	mVO.setId(id);
	mVO.setPw(pw); // 로그인 함수
	int cnt = mDAO.login(mVO); // 리다이렉트뷰 선언 및 초기화
	RedirectView rv = null; // 카운트 값이 1이면
	if( cnt == 1) { // 아이디 값을 얻어서 SID에 담고
	session.setAttribute("SID", mVO.getId());
	System.out.println("Login Session SID : " + session.getAttribute("SID"));
	// 메인화면으로 리다이렉트 시켜준다.
	rv = new RedirectView("/no4/main.no4"); // 카운트 값이 0이면
	} else {
		// 로그인화면으로 다시 리다이렉트 시킨다.
		rv = new RedirectView("signin.no4");
	}
		mv.setView(rv);
		return mv; 
	}
	
	// 로그아웃 처리 함수
	@RequestMapping("/logout.no4")
	public ModelAndView logout(ModelAndView mv, HttpSession session) {
		// 로그인 페이지 view에 담고
		String view = "/no4/member/signin.no4";
		// 리다이렉트 뷰 선언 및 초기화시키고
		RedirectView rv = null;
		// 세션아이디 값 제거
		session.removeAttribute("SID");
		// 세션 아이디 값이 없으면
		if(session.getAttribute("SID") != null) {
			// 뷰를 메인으로 보낸다.
			view = "/cls/main";
			mv.setViewName(view);
		} else {
			// 정상적으로 세션 아이디가 제거됬으면
			// 로그인 페이지 담았던 view를 고대로 써서 로그인 화면으로 뷰를 보낸다.
			rv = new RedirectView(view);
			mv.setView(rv);			
		}
		return mv;
	}
	
	// 회원가입 화면
	@RequestMapping("/signup.no4")
	public ModelAndView join(ModelAndView mv) {
		return mv;
	}
	
	// 회원가입 처리
	@RequestMapping("/signupProc.no4")
	public ModelAndView JoinProc(ModelAndView mv, MemberVO mVO, HttpSession session) {
		int cnt = mDAO.addMember(mVO);
// 		fVO.setMno(mVO.getMno());
		RedirectView rv = null;
		if(cnt == 1) {
			session.setAttribute("SID", mVO.getId());
			rv = new RedirectView("/no4/main.no4");
		} else {
			rv = new RedirectView("/no4/member/signup.no4");
		}
		mv.setView(rv);
		return mv;
	}
	
	@RequestMapping("/test.no4")
	public ModelAndView test(ModelAndView mv) {
		String view = "/member/test";
		mv.setViewName(view);
		return mv;
	}
	
	//아이디 중복확인
	@RequestMapping(value="/idCheck.no4", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(MemberVO mVO) throws Exception {
		int result = mDAO.idCheck(mVO);
		return result;
	}
	
	// 비밀번호 찾기 컨트롤러
	@RequestMapping("pwfind.no4")
	@ResponseBody
	public HashMap<String, String> pwfind(String mail, String id, MemberVO mVO){
		return mSrvc.pwfind(mail, id, mVO);
	}
	
	// 아이디 찾기 컨트롤러
	@RequestMapping("idfind.no4")
	@ResponseBody
	public HashMap<String, String> idfind(String mail, String id, MemberVO mVO){
		return mSrvc.idfind(mail, id, mVO);
	}
	
	// 인증메일 보내기 컨트롤러
	@RequestMapping("mailCk.no4")
	@ResponseBody
	public String mailProc(JoinMailVO jVO) {
		return mSrvc.mailCk(jVO);
	}
	
	// 인증확인 컨트롤러
	@RequestMapping("MailNum.no4")
	@ResponseBody
	public HashMap<String, String> mailNum(JoinMailVO jVO, HttpServletRequest req) {
		return mSrvc.mailNum(jVO, req);
	}
	
	// dataTable 연습
	@RequestMapping("dataTable.no4")
	public ModelAndView dataTable(ModelAndView mv) {
		String view = "dataTable";
		mv.setViewName(view);
		return mv;
	}
}
