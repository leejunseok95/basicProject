package service;

import java.util.Map;

import dao.MemberDAO;
import dao.MemberVO;
import dao.RestaurantDAO;
import dao.RestaurantVO;
import util.ScanUtil;
import util.View;

public class LoginService {
	private LoginService() {
	}

	private static LoginService instance;

	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}

	private MemberDAO memberDao = MemberDAO.getInstance();
	private RestaurantDAO restaurantDao = RestaurantDAO.getInstance();

	public int login() {
		System.out.println("==============로그인=============");
		System.out.println("1. 고객회원 \t 2. 매장회원 \t 0.뒤로가기");
		System.out.println("번호를 입력해주세요>>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			loginMember();
			return View.MAIN;
		case 2:
			loginStore();
			return View.MAIN;
		case 0:
			break;
		default:
			System.out.println("다시 입력해주세요");
			login();
			break;
		}
		return View.HOME;
	}

	private int loginMember() {
		MemberVO mvo = new MemberVO();
		System.out.println("아이디 > ");
		mvo.setMemberLoginId(ScanUtil.nextLine());
		System.out.println("비밀번호 > ");
		mvo.setMemberPass(ScanUtil.nextLine());

		Map<String, Object> Member = memberDao.selectMember(mvo.getMemberId(), mvo.getMemberPass());

		if (Member == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다");
		} else {
			System.out.println("로그인 성공");
			MainService.login = Member;
			System.out.println(MainService.login.get("Member_NAME") + "님 어서오세요");
			return View.MAIN;
		}
		return login();
	}

	public int loginStore() {
		RestaurantVO rvo = new RestaurantVO();
		System.out.println("매장소유자 이름 > ");
		rvo.setRestaurantOwner(ScanUtil.nextLine());
		System.out.println("매장 이름 > ");
		rvo.setRestaurantName(ScanUtil.nextLine());

		Map<String, Object> restaurant = restaurantDao.selectRestaurant(rvo.getRestaurantOwner(), rvo.getRestaurantName());

		if (restaurant == null) {
			System.out.println("매장소유자 이름 혹은 매장 이름을 잘못 입력하셨습니다.");
		} else {
			System.out.println("로그인 성공");
			MainService.login = restaurant;
			System.out.println(MainService.login.get("RESTAURANT_OWNER") + "님 어서오세요");
			return View.MAIN;
		}
		return login();
	}

}
