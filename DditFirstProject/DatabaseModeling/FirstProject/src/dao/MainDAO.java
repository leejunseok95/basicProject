package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MainDAO {
	private static MainDAO instance;
	public static MainDAO getInstance() {
		if(instance == null) {
			instance = new MainDAO();
		}
		return instance;
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	
//	Map<String, Object> param = new HashMap<>();
//	param.put("MENU_NAME", "'%음식이름%'");
//	Map<String, Object> 음식이름 = mainDao.selectMenuName(param);
//	if(음식이름 ==null) {
//		insert음식이름();
//	}
//	
	public Map<String, Object> selectMenuName(Map<String, Object> menuName) {
		String sql = "SELCT * FROM MENU WHERE MENU_NAME = ?";
		List<Object>param = new ArrayList<>();
		param.add(menuName);
		return jdbc.selectOne(sql, param);
	}
	
	public Map<String, Object> selectPorkCutlet() {
		String sql = "SELCT * FROM MENU WHERE MENU_NAME LIKE '%돈까스%'";
		
		return jdbc.selectOne(sql);
	}
}
