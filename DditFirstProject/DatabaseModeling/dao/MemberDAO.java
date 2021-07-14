package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;


public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public MemberDAO() {
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();

	public  int insertMember(Map<String, Object> param) {
		String sql = "INSERT INTO MEMBER"
				    	+ "	VALUES(?,?,?,?,?,?)";
		
		List<Object> p = new ArrayList<>();
		p.add(param.get("MEMBER_ID"));
		p.add(param.get("MEMBER_LOGINID"));
		p.add(param.get("MEMBER_PASSWORD"));
		p.add(param.get("MEMBER_NAME"));
		p.add(param.get("MEMBER_AGE"));
		p.add(param.get("MEMBER_TELNUM"));
		p.add(param.get("MEMBER_AUTHORITY"));
		p.add(param.get("MEMBER_MILEAGE"));
		return jdbc.update(sql, p);
	}

	public Map<String, Object> selectMember(String memberLoginId, String pass){
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_LOGINID = ?"
				+ "AND MEMBER_PASSWORD = ?";
		List<Object>param = new ArrayList<>();
		param.add(memberLoginId);
		param.add(pass);
				
		return jdbc.selectOne(sql, param);
	}
	
	
}
