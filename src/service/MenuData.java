package service;

import java.util.HashMap;
import java.util.Map;

import dao.MainDAO;
import util.JDBCUtil;
import util.ScanUtil;
import vo.MenuVO;

public class MenuData {
	private static MenuData instance;//변수생성
	public static MenuData getInstance(){
		if(instance == null){
			instance = new MenuData();
		}
		return instance;
	}
	
		public MenuData(){
		}
	
		private MainDAO mainDao = MainDAO.getInstance();
		private JDBCUtil jdbc = JDBCUtil.getInstance();
		
		public int Modify() {
			System.out.println("=======================================");
			System.out.println("1. 일식 \t 2.중식 \t 3.한식 \t 4.패스트푸드 \t 5.뒤로가기");
			System.out.print("원하는 번호를 입력하세요>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
				case 1:
					japaneseStyle();
				    break;
				case 2:
					chinaStyle();
					break;
				case 3:
					koreaStyle();
					break;
				case 4:
					junkFood();
					break;
				case 5:
					 
				default:
					System.out.println("다시 입력해주세요");
					break;
			}
			return 0;
		}

		private void japaneseStyle() {
			System.out.println("===================일식==================");
			System.out.println("1. 돈까스 \t 2.초밥 \t 3.라멘 \t 4.덮밥 \t 5.뒤로가기");
			System.out.println("원하는 음식을 선택하세요.");
			
			int input = ScanUtil.nextInt();
			
				switch (input) {
				case 1:
					porkCutlet();
					break;
				case 2:
					sushi();
					break;
				default:
					System.out.println("다시 입력해주세요");
					break;
				}
			
		}
		
		
		private int porkCutlet() {
			Map<String, Object> porkCutlet = mainDao.selectPorkCutlet();
			if(porkCutlet ==null) {
				insertPorkCutlet();
			}
			
			System.out.println("====================돈까스===============");
			String sql  = "SELECT MENU_ID,"
					+ "       RESTAURANT_ID,"
					+ "       MENU_NAME,"
					+ "       MENU_PRICE,"
					+ "       MENU_KIND"
					+ "  FROM MENU "
					+ " WHERE MENU_NAME LIKE '%돈까스%'";
			
			for (Map<String, Object> showporkCutlet : jdbc.selectList(sql)) {
				System.out.println(showporkCutlet);
			}
			System.out.println("=======================================");
			System.out.println("1. 주문하기 \t 2.뒤로가기");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				orderPorkCutlet();
				break;
			case 2: 
				japaneseStyle();
				break;
				
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
			return jdbc.update(sql);
		}
			
			
//			String [] menuKeyname = {"메뉴번호", "식당번호", "메뉴이름","메뉴단가"
//					, "메뉴종류", "재고량"};
//			
//			String [] menuKey = {"MENU_ID", "RESTAURANT_ID", "MENU_NAME"
//					+ "MENU_PRICE", "MENU_KIND", "MENU_TOTAL_STOCK"};
//		System.out.println("===============메뉴별 식당 목록 ================");
//		for (int i = 0; i < menuKey.length; i++) {
//			System.out.println(menuKeyname[i] + " : \t " + porkCutlet.get(menuKey[i]));		
//		}
//		System.out.println("===========================================");

		private void insertPorkCutlet() {
			
		}
		
		private int orderPorkCutlet() {
			Map<String, Object> param = new HashMap<>();
			param.put("MENU_NAME", "'%돈까스%'");
			Map<String, Object> orderporkcutlet = mainDao.selectMenuName(param);
			if(orderporkcutlet ==null) {
				insertPorkCutlet();
			}
			System.out.println("================돈까스 주문===============");
			String sql = "INSERT INTO \"ORDER\""
					+ " VALUES ('B001', 'MEM002', '6000', SYSDATE,'대흥동 연와재',"
					+ " SYSDATE,SYSDATE, '현금')";
			System.out.println("=======================================");
			
		return jdbc.update(sql);
			
			
		}
		
		private void sushi() {
			Map<String, Object> param = new HashMap<>();
			param.put("MENU_NAME", "'%초밥%'");
			Map<String, Object> sushi = mainDao.selectMenuName(param);
			if(sushi ==null) {
				insertsushi();
			}
			
			System.out.println("====================돈까스===============");
			String sql  = "SELECT MENU_ID,"
					+ "       RESTAURANT_ID,"
					+ "       MENU_NAME,"
					+ "       MENU_PRICE,"
					+ "       MENU_KIND"
					+ "  FROM MENU "
					+ " WHERE MENU_NAME LIKE '%돈까스%'";
			
			for (Map<String, Object> showporkCutlet : jdbc.selectList(sql)) {
				System.out.println(showporkCutlet);
			}
			System.out.println("=======================================");
			System.out.println("1. 주문하기 \t 2.뒤로가기");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				orderSushi();
				break;
			case 2: 
				japaneseStyle();
				break;
				
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
		}
		

		private void insertsushi() {
			
		}
		
		private void orderSushi() {
			Map<String, Object> param = new HashMap<>();
			param.put("MENU_NAME", "'%초밥%'");
			Map<String, Object> sushi = mainDao.selectMenuName(param);
			if(sushi ==null) {
				insertsushi();
			}
			System.out.println("================초밥 주문===============");
			String sql = "INSERT INTO \"ORDER\" VALUES ('B002', 'MEM002', '12000'"
					+ "        , SYSDATE,'대흥동 연와재', SYSDATE,SYSDATE, '현금')";
			for (Map<String, Object> showSushi : jdbc.selectList(sql)) {
				System.out.println(showSushi);
			}
			System.out.println("=======================================");
			
		}
}
