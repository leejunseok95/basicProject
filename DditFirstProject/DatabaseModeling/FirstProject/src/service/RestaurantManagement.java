package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import util.ScanUtil;
import util.View;
import vo.MemberVO;
import vo.MenuVO;
import vo.RestaurantVO;

public class RestaurantManagement {
	private static RestaurantManagement instance;

	public static RestaurantManagement getInstance() {
		if (instance == null) {
			instance = new RestaurantManagement();
		}
		return instance;
	}

	private RestaurantData restaurantData = new RestaurantData();
	private static JDBCUtil jdbc = JDBCUtil.getInstance();
	private RestaurantManagement() {
	}

	// 로그인한 회원의 정보를 입력해서 일치 시켜야함(점주인지 아닌지)
	public int myMenu() {
		try {
			if (((BigDecimal) MainService.login.get("AUTH")).intValue() == 2) {
				manageRestaurant();
			} else {
				System.out.println("점주만 확인할 수 있습니다.");
			}
		} catch (NullPointerException e) {

		}
		return View.MAIN;
	}

	public int manageRestaurant() {
		System.out.println("=============매장 관리============");
		System.out.println("1. 주문목록 \t 2.마이페이지");
		System.out.print("번호를 입력해주세요>>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			restaurantOrderList();
			return View.MAIN;
		case 2:
			restaurantMyPage();
			return View.MAIN;
		default:
			System.out.println("다시 입력해주세요");
			break;
		}

		return View.HOME;
	}

	private int restaurantOrderList() {
		while (true) {
			System.out.println("===============================");
			System.out.println("1. 배달하기 \t 2.주문취소 \t 3.뒤로가기");
			//oderservice 56 참조
			Map<String, Object> param = new HashMap<>();
			restaurantData.orderlist(param.put("RESTAURANT_ID", MainService.login.get("RESTAURANT_ID"))); 
			System.out.print("번호를 입력해주세요>>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				delivery();
				break;
			case 2:
				restaurantData.deleteOrderlist();
				break;
			case 3:
				return manageRestaurant();
			default:
				System.out.println("목록에 없는 번호입니다.");
				break;
			}
		}
	}

	private void delivery() {
		//재고량이 없어서 배달이 취소된 경우
		if (true) {
			System.out.println("=============배달 취소============");
		}
		System.out.println("=============배달 현황============");
		System.out.println("1. 배달완료 \t 2.배달중");
		System.out.println("번호를 입력해주세요>>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			break;
		case 2:
			break;
		default:
			System.out.println("목록에 없는 번호입니다.");
			break;
		}
	}

	private void restaurantMyPage() {
		// TODO Auto-generated method stub

	}
}
