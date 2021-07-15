package dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.MainService;
import util.JDBCUtil;

public class OrderMenuDAO {
	private static OrderMenuDAO instance = new OrderMenuDAO();
	public static OrderMenuDAO getInsatnce() {
		return instance;
	}
	
	public OrderMenuDAO() {
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int update(Map<String, Object> ordermenu) {
		String sql = "UPDATE ORDERMENU SET ORDER_ID = ?, MENU_ID = ?,"
				+ "ORDERMENU_QTY = ? WHERE ORDER_ID = ?";
		List<Object> p = new ArrayList<>();
		String [] key = {"ORDER_ID", "MENU_ID", "ORDERMENU_QTY" };
		for (int i = 0; i < key.length; i++) {
			p.add(ordermenu.get(key[i]));
		}
			p.add(ordermenu.get("ORDER_ID"));
		return jdbc.update(sql, p);
	}
	
	public int delete() {

		String sql = "DELETE FROM ORDERMENU WHERE ORDER_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(MainService.login.get("ORDER_ID"));

		return jdbc.update(sql, param);
	}

	public int insertOrderMenuQTY(Map<String, Object> param) {
		String sql = "INSERT INTO ORDERMENU" + "	VALUES(?,?,?)";

		List<Object> p = new ArrayList<>();
		p.add(param.get("MENU_ID"));
		p.add(param.get("ORDER_ID"));
		p.add(param.get("ORDERMENU_QTY"));
		return jdbc.update(sql, p);
	}

	public Map<String, Object> selectOrderMenuQTY(String menuId, String orderId) {
		String sql = "SELECT * FROM ORDERMENU WHERE MENU_ID = ?" + "AND ORDER_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(menuId);
		param.add(orderId);

		return jdbc.selectOne(sql, param);
	}
}
