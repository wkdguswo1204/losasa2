package losasa2.DAO;

import java.sql.*;
import java.util.*;

import losasa2.DB.*;
import losasa2.SQL.*;
import losasa2.VO.*;

public class LosDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	LosSQL lSQL;
	
	public LosDAO(){
		db = new WebDBCP();
		lSQL = new LosSQL();
	}
	// 멤버 조회 함수
	public ArrayList<LosVO> getMemberList(){
		ArrayList<LosVO> list = new ArrayList<LosVO>();
		con = db.getCon();
		String sql = lSQL.getSQL(lSQL.SEL_LOS);
		pstmt = db.getPSTMT(con, sql);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LosVO lVO = new LosVO();
				lVO.setMno(rs.getInt("mno"));
				lVO.setName(rs.getString("name"));
				lVO.setAdmin(rs.getString("admin"));
				lVO.setMsg(rs.getInt("msg"));
				lVO.setSdate(rs.getDate("ldate"));
				lVO.setStime(rs.getTime("ldate"));
				lVO.setLdate();
				list.add(lVO);
			} 
			} catch(Exception e) {
				e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
}
