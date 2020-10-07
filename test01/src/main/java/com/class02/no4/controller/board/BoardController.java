package com.class02.no4.controller.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

import javax.servlet.http.*;

import com.class02.no4.dao.*;
import com.class02.no4.vo.*;
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardDAO bDAO;
	
	// 게시판 뷰
	@RequestMapping("/boardList.no4")
	public ModelAndView boardList(HttpServletRequest req, ModelAndView mv, HttpSession session) {
		//로그인 체크부터
		String sid = (String)session.getAttribute("SID");
		// 세션값에 아이디가 없는 경우
		if(sid == null || sid.length() == 0) {
			// 로그인 창으로 리다이렉트시킨다.
			RedirectView rv = new RedirectView("/no4/member/signin.no4");
			mv.setView(rv);
		} 
		// Board VO 리스트 객체를 선언한다. ※이 때, new 시켯기 떄문에 데이터는 없다.
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// 리스트 뽑아오는 구문을 실행한다.
		List listtest = bDAO.getList();
		
		mv.addObject("LIST", listtest);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	// 게시판 글쓰기 뷰
	@RequestMapping("/boardWrite.no4")
	public ModelAndView boardWrite(ModelAndView mv) {
		mv.setViewName("board/boardWrite");
		return mv;
	}
	// 게시판 글쓰기 데이터베이스 입력처리함수
		@RequestMapping("/boardWriteProc.no4")
		public ModelAndView boardWriteProc (ModelAndView mv, BoardVO bVO, MemberVO mVO, HttpSession session) {
			String sid = (String)session.getAttribute("SID");
			System.out.println("세션아이디 : " + sid);
			bVO.setId(sid);
			bDAO.addList(bVO);
			List list = bDAO.getList();
			mv.addObject("LIST", list);
			mv.setViewName("board/boardList");
			return mv;
		}

	// 게시글 상세보기
		@RequestMapping("/boardDetail.no4")
		public ModelAndView boardDetail (ModelAndView mv, BoardVO bVO, MemberVO mVO, HttpSession session) {
			BoardVO bVO2 = bDAO.getDetail(bVO);
			mv.addObject("DATA",  bVO2);
			mv.setViewName("board/boardDetail");
			return mv;
		}

	// 게시판 수정 뷰
	@RequestMapping("/boardEdit.no4")
	public ModelAndView boardEdit(ModelAndView mv, BoardVO bVO) {
		BoardVO bV03 = bDAO.getDetail(bVO);
		mv.addObject("DATA", bV03);
		mv.setViewName("board/boardEdit");
		return mv;
	}
	
	// 게시판 수정 처리함수
	@Transactional
	@RequestMapping("/boardEditProc.no4")
	public ModelAndView boardEditProc(ModelAndView mv, BoardVO bVO) {
		System.out.println("수정함수 작업전 데이터 : " + bVO);
		System.out.println("test : " + bVO.getTitle());
		bDAO.boardEdit(bVO);
		String view = "/no4/board/boardList.no4";
		RedirectView rv = new RedirectView(view);
		
		mv.setView(rv);
		return mv;
	}
	// 게시글 삭제 처리함수
	@Transactional
	@RequestMapping("/boardDeleteProc.no4")
	public ModelAndView boardDeleteProc(ModelAndView mv, BoardVO bVO) {
		System.out.println("삭제함수 작업전 데이터 : " + bVO);
		bDAO.boardDelete(bVO);
		String view = "/no4/board/boardList.no4";
		RedirectView rv = new RedirectView(view);
		mv.setView(rv);
		return mv;
	}
}
