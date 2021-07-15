package service;

import util.ScanUtil;
import util.View;

public class StoreService {
	private static StoreService instance = new StoreService();

	public static StoreService getInstance() {
		return instance;
	}

	public View login() {
	System.out.println("=================매장로그인===============");
	System.out.println("1.주문조회\t\t2.3.4.");
	System.out.println("원하는 번호를 선택하세요>>");
	int input = ScanUtil.nextInt();
	
	Switch(input){
		case 1:  selectmenu();
			return View.MAIN;
	}
}

}
