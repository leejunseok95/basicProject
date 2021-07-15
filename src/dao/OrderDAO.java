package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.MainService;
import util.JDBCUtil;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	
	public OrderDAO() {
	}
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int update(Map<String, Object> order) {
		String sql = "UPDATE ORDER SET ORDER_ID =?, MEMBER_ID =?, TOTALORDER_PRICE = ?"
				+ "ORDER_DATE = ?, ORDER_DELIVERY_ADD = ?, ORDER_DELIVERY_TIME = ?, "
				+ "SETLEMENT_DATE = ?, SETLEMENT_MEAN =? WHERE ORDER_ID = ? "+"="+"MEMBER_ID = ?";
		List<Object > p = new ArrayList<>();
		String [] key = {"ORDER_ID", "MEMBER_ID", "TOTALORDER_PRICE", "ORDER_DATE", "ORDER_DELIVERY_ADD"
				, "ORDER_DELIVERY_TIME", "SETLEMENT_DATE", "SETLEMENT_MEAN"};
		for(int i = 0; i < key.length; i++) {
			p.add(order.get(key[i]));
		}
			p.add(order.get("ORDER_ID, MEMBER_ID"));
			return jdbc.update(sql, p);
	}
	
	public int delete() {
		String sql = "DELETE FROM ORDER WHERE ORDER_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(MainService.login.get("ORDER_ID"));
		
		return jdbc.update(sql, param);
	}
	
	public int insertOrder(Map<String, Object> param) {
		String sql= "INDERT INTO \"ORDER\" VALUES( ?, ?, ?, ?, ?,?,?,?)";
		
		List<Object> p = new ArrayList<>();
		p.add(param.get("ORDER_ID"));
		p.add(param.get("MEMBER_ID"));
		p.add(param.get("TOTALORDER_PRICE"));
		p.add(param.get("ORDER_DATE"));
		p.add(param.get("ORDER_DELIVERY_ADD"));
		p.add(param.get("ORDER_DELIVERY_TIME"));
		p.add(param.get("SETLEMENT_DATE"));
		p.add(param.get("SETLEMENT_MEAN"));
		
		return jdbc.update(sql, p);
	}
	
	public Map<String, Object> selectOrder(String orderId, String memberid){
		String sql = "SELECT * FROM ORDER WHERE ORDER_ID = ?"
				+ "AND MEMBER_ID = ?";
		List<Object>param = new ArrayList<>();
		param.add(orderId);
		param.add(memberid);
				
		return jdbc.selectOne(sql, param);
	}
	
}
