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

	public int login() {
		System.out.println("==============로그인=============");
		System.out.println("1. 고객회원 \t 0.뒤로가기");
		System.out.print("번호를 입력해주세요>>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			loginMember();
			return View.MAIN;
		case 0:
			System.out.println("감사합니다. 안녕히 가세요");
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
		System.out.print("아이디 > ");
		mvo.setMemberLoginId(ScanUtil.nextLine());
		System.out.print("비밀번호 > ");
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
}
