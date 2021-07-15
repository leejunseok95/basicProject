package vo;


public class OrderMenuVO {
	private String orderId;
	MenuVO menuId;
	private int orderMenuQTY;
	
	public OrderMenuVO() {
	}

	public OrderMenuVO(String orderId, MenuVO menuId, int orderMenuQTY) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.orderMenuQTY = orderMenuQTY;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getOrderMenuQTY() {
		return orderMenuQTY;
	}

	public void setOrderMenuQTY(int orderMenuQTY) {
		this.orderMenuQTY = orderMenuQTY;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderMenuVO [orderId=");
		builder.append(orderId);
		builder.append(", orderMenuQTY=");
		builder.append(orderMenuQTY);
		builder.append("]");
		return builder.toString();
	}
	
	
}
