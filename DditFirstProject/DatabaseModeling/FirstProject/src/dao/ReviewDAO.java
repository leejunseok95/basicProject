package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.MainService;
import util.JDBCUtil;

public class ReviewDAO {
	private static ReviewDAO instance = new ReviewDAO();
	public static ReviewDAO getInstance() {
		return instance;
	}
	
	public ReviewDAO() {
	}
	
	private static JDBCUtil jdbc= JDBCUtil.getInstance();
	
	public int update(Map<String, Object> review) {
		String sql = "UPDATE REVIEW SET REVIEW_CONTENTS = ?, REVIEW_STAR = ?"
				+ "WHERE REVIEW_ID =? AND ORDER_ID = ?";
		List<Object> p = new ArrayList<Object>();
		String[] key = {"REVIEW_CONTENTS", "REVIEW_STAR"};
		
		for (int i = 0; i < key.length; i++) {
			p.add(review.get(key[i]));
		}
		p.add(review.get("REVIEW_ID"));
		p.add(review.get("REVIEW_STAR"));
		return jdbc.update(sql,p);
	}
	
	public int delete() {
		String sql = "DELETE FROM REVIEW WHERE REVIEW_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(MainService.login.get("REVIEW_ID"));
		
		return jdbc.update(sql, param);
	}
	
	public  int insertReview(Map<String, Object> param) {
		String sql = "INSERT INTO REVIEW"
				    	+ "	VALUES(?,?,?,?)";
		
		List<Object> p = new ArrayList<>();
		p.add(param.get("REVIEW_ID"));
		p.add(param.get("REVIEW_CONTENTS"));
		p.add(param.get("REVIEW_STAR"));
		p.add(param.get("ORDER_ID"));
		return jdbc.update(sql, p);
	}
	
	//다시 한번 확인, memberId
	public Map<String, Object> selectReview(String memberId){
		String sql = "SELECT A.MEMBER_ID,"
				+ "       A.MEMBER_NAME,"
				+ "       B.REVIEW_STAR,"
				+ "       B.REVIEW_CONTENTS"
				+ "  FROM MEMBER A, REVIEW B, \"ORDER\" C"
				+ "  WHERE A.MEMBER_ID = C.MEMBER_ID"
				+ "    AND C.ORDER_ID = B.ORDER_ID"
				+ "    AND A.MEMBER_ID = ?";
		List<Object>param = new ArrayList<>();
		param.add(memberId);
				
		return jdbc.selectOne(sql, param);
	}
	
}
