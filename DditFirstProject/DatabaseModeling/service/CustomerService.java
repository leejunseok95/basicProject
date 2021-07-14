  
package service;

import java.util.List;

import util.ScanUtil;
import util.View;

public class CustomerService {
	private static CustomerService instance = new CustomerService();
	public static CustomerService getInstance() {
		return instance;
	}
	
	private CustomerService() {
	}
	
	
	public View login() {
		System.out.println("=================고객로그인===============");
		System.out.println("1.식사메뉴선택\t\t2.3.4.");
		System.out.println("원하는 번호를 선택하세요>>");
		int input = ScanUtil.nextInt();
		
		Switch(input){
			case 1:  selectmenu();
				return View.MAIN
		}
	}
}