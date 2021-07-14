package dao;


public class OrderVO {
	private String orderId;
	MemberVO memberId;
	private String totalorderPrice;
	private String orderDate;
	private String orderDeliveryAdd;
	private String orderDeliveryTime;
	private String setlementDate;
	private String setlementMean;
	
	public OrderVO() {
	}

	public OrderVO(String orderId, MemberVO memberId, String totalorderPrice, String orderDate, String orderDeliveryAdd,
			String orderDeliveryTime, String setlementDate, String setlementMean) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.totalorderPrice = totalorderPrice;
		this.orderDate = orderDate;
		this.orderDeliveryAdd = orderDeliveryAdd;
		this.orderDeliveryTime = orderDeliveryTime;
		this.setlementDate = setlementDate;
		this.setlementMean = setlementMean;
	}



	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTotalorderPrice() {
		return totalorderPrice;
	}
	public void setTotalorderPrice(String totalorderPrice) {
		this.totalorderPrice = totalorderPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderDeliveryAdd() {
		return orderDeliveryAdd;
	}
	public void setOrderDeliveryAdd(String orderDeliveryAdd) {
		this.orderDeliveryAdd = orderDeliveryAdd;
	}
	public String getOrderDeliveryTime() {
		return orderDeliveryTime;
	}
	public void setOrderDeliveryTime(String orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}
	public String getSetlementDate() {
		return setlementDate;
	}
	public void setSetlementDate(String setlementDate) {
		this.setlementDate = setlementDate;
	}
	public String getSetlementMean() {
		return setlementMean;
	}
	public void setSetlementMean(String setlementMean) {
		this.setlementMean = setlementMean;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderVO [orderId=");
		builder.append(orderId);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", totalorderPrice=");
		builder.append(totalorderPrice);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", orderDeliveryAdd=");
		builder.append(orderDeliveryAdd);
		builder.append(", orderDeliveryTime=");
		builder.append(orderDeliveryTime);
		builder.append(", setlementDate=");
		builder.append(setlementDate);
		builder.append(", setlementMean=");
		builder.append(setlementMean);
		builder.append("]");
		return builder.toString();
	}
	
}
