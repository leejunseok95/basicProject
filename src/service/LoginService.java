package service;

import java.util.Map;

import dao.MemberDAO;
import dao.RestaurantDAO;
import util.ScanUtil;
import util.View;
import vo.MemberVO;
import vo.RestaurantVO;

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
		System.out.println("1. 고객회원 \t 2. 매장회원 \t 3.계정찾기 \t0.뒤로가기");
		System.out.println("번호를 입력해주세요>>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			loginMember();
			return View.MAIN;
		case 2:
			loginRestaurant();
			return View.MAIN;
		case 3:
			accountSearch();
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

	public int loginRestaurant() {
		RestaurantVO rvo = new RestaurantVO();
		System.out.println("매장소유자 이름 > ");
		rvo.setRestaurantOwner(ScanUtil.nextLine());
		System.out.println("매장 이름 > ");
		rvo.setRestaurantName(ScanUtil.nextLine());

		Map<String, Object> restaurant = restaurantDao.viewRestaurant(rvo.getRestaurantOwner(), rvo.getRestaurantName());

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
	
	public int accountSearch() {
	      System.out.println("==============계정찾기=============");
	      System.out.println("ID를 입력해주세요.");
	      String id = ScanUtil.nextLine();
	      System.out.println("생년월일을 입력해주세요(ex)19961130).");
	      String birth = ScanUtil.nextLine();

	      Map<String, Object> account = memberDao.selectMemberSearchAccount(id, birth);

	      if (account == null) {
	         System.out.println("아이디 혹은 생년월일을 잘못 입력하셨습니다.");
	      }else {
	         System.out.println("아이디와 생년월일이 일치합니다.");
	         System.out.println("변경할 비밀번호를 입력해주세요.");
	         String pass = ScanUtil.nextLine();
	         System.out.println("한번 더 입력해주세요.");
	         String passCheck = ScanUtil.nextLine();
	         if (pass.equals(passCheck)) {
	            System.out.println("비밀번호가 성공적으로 변경되었습니다.");
	            return View.HOME;
	         }else {
	            System.out.println("비밀번호 확인과 일치하지 않습니다.");
	            return View.ACCOUNTSEARCH;
	         }
	      }
	      return login();
	   }
}
