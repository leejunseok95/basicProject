package service;

import util.ScanUtil;
import util.View;

public class DeliveryService {
	private static DeliveryService instance = new DeliveryService();
	public static DeliveryService getInstance() {
		return instance;
}
	
	public View login() {
		System.out.println("=================배달기사로그인===============");
		System.out.println("1.배차정보\t\t2.3.4.");
		System.out.println("원하는 번호를 선택하세요>>");
		int input = ScanUtil.nextInt();
		
		Switch(input){
			case 1:  selectmenu();
				return View.MAIN;
		
			}
		}	
}
