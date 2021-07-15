package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.MainService;
import util.JDBCUtil;

public class AddressDAO {
	private static AddressDAO instance = new AddressDAO();

	public static AddressDAO getInstance() {
		return instance;
	}

	public AddressDAO() {
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();

	public int update(Map<String, Object> address) {
		String sql = "UPDATE ADDRESS SET ADDRESS_ADD2 = ?, MEMBER_ID = ?, ADDRESS_ADD1 = ?"
				+ "WHERE MEMBER_ID = ?";
		
		List<Object> p = new ArrayList<>();
		String [] key = { "ADDRESS_ADD2", "MEMBER_ID", "ADDRESS_ADD1"};
		for (int i = 0; i < key.length; i++) {
			p.add(address.get(key[i]));
		}
			p.add(address.get("MEMBER_ID"));
		return jdbc.update(sql, p);
	}
	
	public int delete() {
		String sql = "DELETE FROM ADDRESS WHERE MEMBER_ID = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(MainService.login.get("MEMBER_ID"));

		return jdbc.update(sql, param);
	}

	public int insertAddress(Map<String, Object> param) {
		String sql = "INSERT INTO ADDRESS" + "	VALUES(?,?,?)";
		
		List<Object> p = new ArrayList<>();
		p.add(param.get("ADDRESS_ADD2"));
		p.add(param.get("MEMBER_ID"));
		p.add(param.get("ADDRESS_ADD1"));
		return jdbc.update(sql, p);
	}
	
	public Map<String, Object> selectAddress(String memberId) {
		String sql = "SELECT * FROM ADDRESS WHERE MEMBER_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(memberId);
		
		return jdbc.selectOne(sql, param);
	}
}
