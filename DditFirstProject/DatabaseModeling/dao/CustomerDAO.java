package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;


public class CustomerDAO {
	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}
	
	private CustomerDAO() {
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();

	public static  int insertCustomer(Map<String, Object> param) {
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

	public Map<String, Object> selectUser(String customerId, String passWord){
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_LOGINID = ?"
				+ "AND MEMBER_PASSWORD = ?";
		List<Object>param = new ArrayList<>();
		param.add(customerId);
		param.add(passWord);
				
		return jdbc.selectOne(sql, param);
	}
	
	
}
