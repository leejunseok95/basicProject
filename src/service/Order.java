package service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import dao.MenuDAO;
import dao.RestaurantDAO;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class Order {
	private static Order instance;
	public static Order getInstance() {
		if(instance == null) {
			instance = new Order();
		}
		return instance;
	}
	private MenuDAO menuDao = MenuDAO.getInstance();
	private MenuData menuData = MenuData.getInstance();
	private RestaurantDAO restaurantDao = RestaurantDAO.getInstance();
	private RestaurantData restaurantData = RestaurantData.getInstance(); 
	
	public int myMenu() {
		try {
			if (((BigDecimal) MainService.login.get("AUTH")).intValue() == 1) {
				choiceMenu();
			} else {
				System.out.println("회원 로그인만 확인할 수 있습니다.");
			} 
		} catch (NullPointerException e) {

			}
	return View.MAIN;
	}
	
	public void choiceMenu() {
		System.out.println("============================");
		System.out.println("1. 메뉴별 \t 2. 식당별 \t 3.뒤로가기");
		System.out.println("원하는 메뉴번호를 입력하세요>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			menuList();
			break;
		case 2:
			restaurantList();
		default:
			System.out.println("다시 입력해주세요");
			break;
		}
	}

	private void menuList() {
		Map<String, Object> param = new HashMap<>();
		param.put("MENU_NAME", MainService.login.get("MENU_NAME"));
		Map<String, Object> menuList = menuDao.selectMenu(param);
		if(menuList ==null) {
			insertMenu();
		}
		
		String [] menuKeyname = {"메뉴번호", "식당번호", "메뉴이름","메뉴단가"
				, "메뉴종류", "재고량"};
		
		String [] menuKey = {"MENU_ID", "RESTAURANT_ID", "MENU_NAME"
				+ "MENU_PRICE", "MENU_KIND", "MENU_TOTAL_STOCK"};
	System.out.println("===============메뉴별 식당 목록 ================");
	for (int i = 0; i < menuKey.length; i++) {
		System.out.println(menuKeyname[i] + " : \t " + menuList.get(menuKey[i]));		
	}
	System.out.println("===========================================");
	menuData.Modify();
	}
	
	private void restaurantList() {
		Map<String, Object> param = new HashMap<>();
		param.put("RESTAURANT_NAME", MainService.login.get("RESTAURANT_NAME"));
		Map<String, Object> menuList = restaurantDao.selectRestaurant(param);
		if(menuList ==null) {
			insertrestaurant();
		}
		
		String [] restaurantKeyname = {"식당번호", "식당이름", "식당 전화번호","식당 주소"
				, "식당 사장 이름", "식당 분류 코드"};
		
		String [] restaurantKey = {"RESTAURANT_ID", "RESTAURANT_NAME", "RESTAURANT_TELNUMBER"
				+ "RESTAURANT_ADD", "RESTAURANT_OWNER", "RESTAURANT_CLASSIFICATION"};
	System.out.println("===============메뉴별 식당 목록 ================");
	for (int i = 0; i < restaurantKey.length; i++) {
		System.out.println(restaurantKeyname[i] + " : \t " + menuList.get(restaurantKey[i]));		
	}
	System.out.println("===========================================");

	}
	
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private void insertMenu() {
		System.out.println("등록된 메뉴가 없습니다.");
		System.out.println("2. 뒤로가기");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 2: choiceMenu();
		break;
		default:
			System.out.println("다시 입력해주세요");
			break;
		}
	}
	
	private void insertRestaurant() {
		System.out.println("등록된 식당이 없습니다.");
		System.out.println("2. 뒤로가기");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 2: choiceMenu();
			break;
		default:
			System.out.println("다시 입력해주세요");
			break;
		}
	}
		
		public int restaurantdata(){
			String [] keyname = {"식당번호", "식당이름", "식당전화번호", "식당주소", "식당사장", "식당분류코드"};
			String [] key = {"RESTAURANT_ID", "RESTAURANT_NAME", "RESTAURANT_TELNUMBER", "RESTAURANT_ADD", "RESTAURANT_OWNER", "RESTAURANT_CLASSIFICATION"};
			System.out.println("===============식당정보====================");
			for(int i = 0; i < keyname.length; i++) {
				System.out.println(keyname[i] + ":" + MainService.login.get(key[i]));
			}
			System.out.println("=========================================");
			restaurantData.Modify();
			return 0;
	
		}
	
	}
