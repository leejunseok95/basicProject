package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.MainDAO;
import util.JDBCUtil;
import util.ScanUtil;

public class RestaurantData {
	private static RestaurantData instance = new RestaurantData();
	
	public static RestaurantData getInstance() {
		if (instance == null) {
			instance = new RestaurantData();
		}
		return instance;
	}
	
	public RestaurantData() {
	}
	private MainDAO mainDao = MainDAO.getInstance();
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public void orderlist(Object object) {
		System.out.println("=============주문 목록============");// 현재 주문이 들어가 있는 목록을 뽑아오기 위해 사용
		String sql = "SELECT A.ORDER_ID, B.MENU_NAME, D.ORDERMENU_QTY," + "(B.MENU_PRICE*D.ORDERMENU_QTY),"
				+ "       A.ORDER_DELIVERY_ADD, E.MEMBER_TELNUM"
				+ "  FROM \"ORDER\" A, MENU B, RESTAURANT C, ORDERMENU D, MEMBER E"
				+ " WHERE C.RESTAURANT_ID = B.RESTAURANT_ID" + "   AND A.ORDER_ID = D.ORDER_ID"
				+ "   AND B.MENU_ID = D.MENU_ID" + "   AND E.MEMBER_ID = A.MEMBER_ID" + "   AND C.RESTAURANT_ID = ?";

		List<Object> p = new ArrayList<>();
		p.add("RESTAURANT_ID");
		
		for (Map<String, Object> order : jdbc.selectList(sql, p)) {
			System.out.println(order);
		}
	}
	
	public int deleteOrderlist() {
		System.out.print("삭제할 주문번호를 입력해주세요>> ");
		String deleteList = ScanUtil.nextLine();
		
		String sql = "DELETE FROM ORDERMENU" + "WHERE ORDER_ID = ?";
		List<Object> p = new ArrayList<Object>();
		p.add(deleteList);
		
		return jdbc.update(sql,p);
	}
} 
