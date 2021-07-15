package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MenuDAO {
	private static MenuDAO instance = new MenuDAO();
	public static MenuDAO getInstance() {
		return instance;
	}
	
	public MenuDAO() {
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int update(Map<String, Object> menu) {
		String sql = "UPDATE MENU\r\n"
				+ "   SET MENU_NAME = ?, MENU_PRICE = ?,\r\n"
				+ "       MENU_KIND = ?, MENU_TOTAL_STOCK = ?\r\n"
				+ " WHERE RESTAURANT_ID = ?";
		List<Object> p = new ArrayList<Object>();
		String [] key = {"MENU_NAME","MENU_PRICE","MENU_KIND", "MENU_TOTAL_STOCK"};
		for (int i = 0; i < key.length; i++) {
			p.add(menu.get(key[i]));
		}
		p.add(menu.get("RESTAURANT_ID"));
		return jdbc.update(sql,p);
	}
	
	public int delete() {
		String sql = "DELETE FROM MENU WHERE MENU_ID = ?";
		List<Object> param = new ArrayList<Object>();
		
		return jdbc.update(sql,param);
	}
	
	public int insertMenu(Map<String, Object> param) {
		String sql = "INSERT INTO MENU"
				+ "VALUES(?,?,?,?,?,?)";
		List<Object> p = new ArrayList<>();
		p.add(param.get("MENU_ID"));
		p.add(param.get("RESTAURANT_ID"));
		p.add(param.get("MENU_NAME"));
		p.add(param.get("MENU_PRICE"));
		p.add(param.get("MENU_KIND"));
		p.add(param.get("MENU_TOTAL_STOCK"));
		return jdbc.update(sql,p);
	}
	
	public Map<String, Object> selectMenu(Map<String, Object> menuName) {
		String sql = "SELECT * FROM MENU WHERE MENU_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(menuName);
		
		return jdbc.selectOne(sql,param);
	}
	
//	public Map<String, Object> selectMenu(String menuId, String restaurantId) {
//		String sql = "SELECT * FROM MENU WHERE MENU_ID = ?"
//				+ "AND RESTAURANT_ID = ?";
//		List<Object> param = new ArrayList<>();
//		param.add(menuId);
//		param.add(restaurantId);
//		
//		return jdbc.selectOne(sql,param);
//	}
}
