package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class RestaurantDAO {
	private static RestaurantDAO instance = new RestaurantDAO();
	public static RestaurantDAO getInstance() {
		return instance;
	}

	public RestaurantDAO() {
	}

	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public static int insertRestaurant(Map<String, Object> param) {
		String sql = "INSERT INTO RESTAURANT"
           				+ "	VALUES(?,?,?,?,?,?)";
			
		List<Object> p = new ArrayList<>();
		p.add(param.get("RESTAURANT_ID"));
		p.add(param.get("RESTAURANT_NAME"));
		p.add(param.get("RESTAURANT_TELNUMBER"));
		p.add(param.get("RESTAURANT_ADD"));
		p.add(param.get("RESTAURANT_OWNER"));
		p.add(param.get("RESTAURANT_CLASSIFICATION"));
		return jdbc.update(sql, p);
	}
	
	public Map<String, Object> selectRestaurant(String restaurantOwner, String restaurantName){
		String sql = "SELCT * FROM RESTAURANT WHERE RESTAURANT_OWNER = ?"
				+"AND RESTAURANT_NAME = ?";
		List<Object>param = new ArrayList<>();
		param.add(restaurantOwner);
		param.add(restaurantName);
		
		return jdbc.selectOne(sql, param);
	}
}
