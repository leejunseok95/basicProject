package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.MainService;
import util.JDBCUtil;

public class RestaurantDAO {
	private static RestaurantDAO instance = new RestaurantDAO();
	public static RestaurantDAO getInstance() {
		return instance;
	}


	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	

	public int update(Map<String, Object> restaurant) {
		String sql = "UPDATE RESTAURANT SET RESTAURANT_ID = ?, RESTAURANT_NAME=?,"
				+ " RESTAURANT_TELNUMBER=?, RESTAURANT_ADD= ?, RESTAURANT_OWNER =?, "
				+ "RESTAURANT_CLASSICFICATION = ? WHERE RESTAURANT_ID= ?";
		List<Object> p = new ArrayList<>();
		String [] key = {"RESTAURANT_ID", "RESTAURANT_NAME", "RESTAURANT_TELNUMBER", "RESTAURANT_ADD"
				, "RESTAURANT_OWNER", "RESTAURANT_CLASSICFICATION"};
		for (int i = 0; i < key.length; i++) {
			p.add(restaurant.get(key[i]));
		}
			p.add(restaurant.get("RESTAURANT_ID"));
			
			return jdbc.update(sql, p);
		}
	
	public int delete() {
		String sql = "DELETE FROM RESTAURANT WHERE RESTAURANT_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(MainService.login.get("RESTAURANT_ID"));
		
		return jdbc.update(sql, param);
	}
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
	
	public Map<String, Object> viewRestaurant(String restaurantId, String restaurantName){
		String sql = "SELCT * FROM RESTAURANT WHERE RESTAURANT_ID = ? "
					 + "	AMD RESTAURANT_NAME =? ";
		List<Object>param = new ArrayList<>();
		param.add(restaurantId);
		param.add(restaurantName);
		
		return jdbc.selectOne(sql, param);
	}
	
	public Map<String, Object> selectRestaurant(Map<String, Object> restaurantId){
		String sql = "SELCT * FROM RESTAURANT WHERE RESTAURANT_ID = ?";
		List<Object>param = new ArrayList<>();
		param.add(restaurantId);
		
		return jdbc.selectOne(sql, param);
	}
	
}
