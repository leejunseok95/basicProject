package service;

import java.util.Map;

import util.ScanUtil;
import util.View;

public class MainService {
	public static Map<String, Object> login;

	private MainService() {
	}

	private static MainService instance;

	public static MainService getInstance() {
		if (instance == null) {
			instance = new MainService();
		}
		return instance;
	}

	public static void main() {
		new MainService().service();
	}

	private Order order = Order.getInstance();
	private MyPage myPage = MyPage.getInstance();
	private RecommandMenu recommandMenu = RecommandMenu.getInstance();
	
	public int service() {
		int view = View.MAIN;
		
		while(true) {
			switch(view) {
			case View.MAIN: view = serviceList();
				break;
			case View.MYPAGE: view = myPage();
			break;
			
			}
		}
	}


	public int serviceList() {
		System.out.println("===================================");
		System.out.println(" 1. 주문 \t 2. 마이페이지 \t 3.음식추천 \t 0.종료");
		System.out.println("===================================");
		System.out.print("번호를 선택하세요 > ");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			return View.ORDER;
		case 2:
			return View.MYPAGE;
		case 3:
			return View.RECOMMANDATION;
		case 0:
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		default:
			System.out.println("잘못 입력하였습니다");
			break;
		}
		return View.MAIN;

	}

	private int myPage() {
		return 0;
	}
}
