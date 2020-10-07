package com.class02.no4.dao;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import com.class02.no4.vo.*;

public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	// 로그인 처리 전담 함수
	public int login(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.login", mVO);
	}
	
	// 회원가입 처리 전담 함수
	public int addMember(MemberVO mVO) {
		return sqlSession.insert("mSQL.addMember", mVO);
	}
	
	// 아이디 중복확인
	public int idCheck(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.idCheck", mVO);
	}
	
	// 비밀번호 찾기 전담 함수
	public int pwfind(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.pwfind", mVO);
	}
	
	// 임시비번 변경 전담 함수
	public int pwchange(MemberVO mVO) {
		return sqlSession.update("mSQL.pwchange", mVO);
	}
	// 아이디 찾기 전담 함수
	public String idfind(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.idfind", mVO);
	}
}
