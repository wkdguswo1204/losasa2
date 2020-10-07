package com.class02.no4.dao;

import java.util.*;

import org.mybatis.spring.*;
import com.class02.no4.vo.*;
import org.springframework.beans.factory.annotation.*;

public class BoardDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int getCnt() {
		return sqlSession.selectOne("bSQL.selCnt");
	}
	
	public List getList() {
		return sqlSession.selectList("bSQL.getList");
	}
	
	public int addList(BoardVO bVO) {
		return sqlSession.insert("bSQL.addList", bVO);
	}
	
	public BoardVO getDetail(BoardVO bVO) {
		return sqlSession.selectOne("bSQL.getDetail", bVO);
	}
	public int boardEdit(BoardVO bVO) {
		return sqlSession.update("bSQL.boardEdit", bVO);
	}
	public int boardDelete(BoardVO bVO) {
		return sqlSession.delete("bSQL.boardDelete", bVO);
	}
}
