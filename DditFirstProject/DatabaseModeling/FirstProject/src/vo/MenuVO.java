package vo;

public class MenuVO {
	private String menuId;
	RestaurantVO restaurantId;
	private String menuName;
	private int menuPrice;
	private String menuKind;
	private int menuTotalStock;
	
	MenuVO(){
	}

	public MenuVO(String menuId, RestaurantVO restaurantId, String menuName, int menuPrice, String menuKind,
			int menuTotalStock) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuKind = menuKind;
		this.menuTotalStock = menuTotalStock;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuKind() {
		return menuKind;
	}

	public void setMenuKind(String menuKind) {
		this.menuKind = menuKind;
	}

	public int getMenuTotalStock() {
		return menuTotalStock;
	}

	public void setMenuTotalStock(int menuTotalStock) {
		this.menuTotalStock = menuTotalStock;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuVO [menuId=");
		builder.append(menuId);
		builder.append(", restaurantId=");
		builder.append(restaurantId);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", menuPrice=");
		builder.append(menuPrice);
		builder.append(", menuKind=");
		builder.append(menuKind);
		builder.append(", menuTotalStock=");
		builder.append(menuTotalStock);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
