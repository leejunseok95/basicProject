package service;

import java.util.HashMap;
import java.util.Map;

import dao.MemberDAO;
import dao.MemberVO;
import dao.RestaurantDAO;
import dao.RestaurantVO;
import util.ScanUtil;
import util.View;

public class JoinService {
	
	private JoinService() {
	}
	
	private static JoinService instance;
	public static JoinService getInstance() {
		if(instance ==null) {
			instance = new JoinService();
		}
		return instance;
	}
	
	private MemberDAO memberDao = MemberDAO.getInstance();
	
	public int join() {
		System.out.println("===============회원가입=================");
		System.out.println("회원가입을 환영합니다");
		System.out.println("1.개인회원가입\t2.식당회원가입\t0.이전메뉴로");
		System.out.println("번호를 입력해주세요>");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1: joinMember();
			break;
		case 2: joinRestaurant();
		case 0: 
			System.out.println("이전 화면으로 돌아갑니다");
			break;
		default:
			System.out.println("다시 입력해주세요");
			join();
			break;
		}
		return View.HOME;
	}
	
	private void joinMember() {
		MemberVO mvo = new MemberVO();
		System.out.println("개인 회원가입입니다.");
		System.out.println("상세 정보를 입력해주세요.");
		System.out.print("아이디>");
		mvo.setMemberLoginId(ScanUtil.nextLine());
		System.out.print("비밀번호>");
		mvo.setMemberPass(ScanUtil.nextLine());
		System.out.print("이름>");
		mvo.setMemberName(ScanUtil.nextLine());
		System.out.print("나이>");
		mvo.setMemberAge(ScanUtil.nextLine());
		System.out.print("휴대전화번호>");
		mvo.setMemberTelNum(ScanUtil.nextLine());
		
		Map<String, Object> param = new HashMap<>();
		param.put("MEMBER_LOGINID", mvo.getMemberLoginId());
		param.put("MEMBER_PASS", mvo.getMemberPass());
		param.put("MEMBER_NAME", mvo.getMemberName());
		param.put("MEMBER_AGE", mvo.getMemberAge());
		param.put("MEMBER_TELNUM", mvo.getMemberTelNum());
		param.put("AUTH", 1);

		int result = memberDao.insertMember(param);
		
		if( result  > 0) {
			System.out.println("회원가입 되었습니다.");
		}else {
			System.out.println("회원가입 실패 다시 입력해주세요.");
		}
	}
	
	private void joinRestaurant() {
		RestaurantVO rvo = new RestaurantVO();
		System.out.println("식당 회원가입입니다.");
		System.out.println("상세정보 입력해주세요.");
		System.out.print("식당이름>");
		rvo.setRestaurantName(ScanUtil.nextLine());
		System.out.print("식당전화번호>");
		rvo.setRestaurantTelNumber(ScanUtil.nextLine());
		System.out.print("식당주소>");
		rvo.setRestaurantAdd(ScanUtil.nextLine());
		System.out.print("식당소유자 이름>");
		rvo.setRestaurantOwner(ScanUtil.nextLine());
		
		Map<String, Object> param = new HashMap<>();
		param.put("RESTAURANT_NAME", rvo.getRestaurantName());
		param.put("RESTAURANT_TELNUMBER", rvo.getRestaurantTelNumber());
		param.put("RESTAURANT_ADD", rvo.getRestaurantAdd());
		param.put("RESTAURANT_OWNER", rvo.getRestaurantOwner());
		
		int result = RestaurantDAO.insertRestaurant(param);
		
		if(result > 0) {
			System.out.println("매장 회원가입 되었습니다.");
		}else {
			System.out.println("회원가입 실패 다시 입력해주세요.");
		}
	}

}
