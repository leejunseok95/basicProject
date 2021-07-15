package controller;


import service.JoinService;
import service.LoginService;
import service.MainService;
import util.ScanUtil ;
import util.View;

public class Controller {
	public static void main(String[] args) {
		new Controller().start();
	}

	private JoinService joinService = JoinService.getInstance();
	private LoginService loginService = LoginService.getInstance();
	private MainService mainService = MainService.getInstance();
	
	public int start() {
		int view = View.HOME;

		while (true) {
			switch (view) {
			case View.HOME:	view = home();
			break;
			case View.LOGIN:	view = loginService.login();
				break;
			case View.JOIN:    view = joinService.join();
				break;
			case View.MAIN:	view = mainService.service();
				break;
			default:
				break;

			}
		}
	}

	private int home() {
		System.out.println("===========배달의 민족==============");
		System.out.println("1. 로그인\\t\\t2.회원가입");
		System.out.println("5. 프로그램 종료");
		System.out.print("번호를 입력하세요>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1: return View.LOGIN;
		case 2: return View.JOIN;
		case 5:
			System.out.println("프로그램 종료");
			System.exit(5);
		default:
			System.out.println("잘못된 입력입니다 다시 입력해주세요");
			break;
		}
		return View.HOME;
	}
}
