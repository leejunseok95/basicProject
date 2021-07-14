package service;

import java.util.HashMap;
import java.util.Map;

import util.ScanUtil;

public class Order {
	private static Order instance;
	public static Order getInstance() {
		if(instance == null) {
			instance = new Order();
		}
		return instance;
	}
	
	public void choiceMenu() {
		System.out.println("============================");
		System.out.println("1.치킨 \t 2.짜장면 \t 3.도시락");
		System.out.println("원하는 메뉴번호를 입력하세요>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			chicken();
			break;
		case 2:
			chineseFood();
		}
	}

	private void chicken() {
		Map<String, Object> param = new HashMap<>();
		param.put("MENU_NAME", MainService.login.get("MENU_NAME"));
		Map<String, Object> chicken = chichkenDao.selectRestaurant(param);
		if(chicken ==null) {
			insertChicken();
		}
		String [] RestaurantKey = {"RESTAURANT_ID", "RESTAURANT_NAME", "RESTAURANT_TELNUMBER"
				+ "RESTAURANT_ADD", "RESTAURANT_OWNER", "RESTAURANT_CLASSIFICATION"};
				
		String [] RestaurantKeyname = {"식당 번호", "식당 이름", "식당 전화번호","식당 주소"
				, "식당 사장이름", "식당 분류코드"};
	
	System.out.println("===============치킨 메뉴있는 식당 ===============");
	for (int i = 0; i < RestaurantKey.length; i++) {
		System.out.println(RestaurantKeyname[i] + " : \t " + chicken.get(RestaurantKey[i]));		
	}
	System.out.println("===========================================");
		
	
	
	
	
	
	
	}
}
