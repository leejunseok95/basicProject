package vo;


public class RestaurantVO {
	private String RestaurantId;
	private String RestaurantName;
	private String RestaurantTelNumber;
	private String RestaurantAdd;
	private String RestaurantOwner;
	private String RestaurantClassifiction;
	
	public RestaurantVO() {
	}
	
	public RestaurantVO(String restaurantId, String restaurantName, String restaurantTelNumber, String restaurantAdd,
			String restaurantOwner, String restaurantClassifiction) {
		super();
		RestaurantId = restaurantId;
		RestaurantName = restaurantName;
		RestaurantTelNumber = restaurantTelNumber;
		RestaurantAdd = restaurantAdd;
		RestaurantOwner = restaurantOwner;
		RestaurantClassifiction = restaurantClassifiction;
	}

	public String getRestaurantId() {
		return RestaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		RestaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return RestaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}

	public String getRestaurantTelNumber() {
		return RestaurantTelNumber;
	}

	public void setRestaurantTelNumber(String restaurantTelNumber) {
		RestaurantTelNumber = restaurantTelNumber;
	}

	public String getRestaurantAdd() {
		return RestaurantAdd;
	}

	public void setRestaurantAdd(String restaurantAdd) {
		RestaurantAdd = restaurantAdd;
	}

	public String getRestaurantOwner() {
		return RestaurantOwner;
	}

	public void setRestaurantOwner(String restaurantOwner) {
		RestaurantOwner = restaurantOwner;
	}

	public String getRestaurantClassifiction() {
		return RestaurantClassifiction;
	}

	public void setRestaurantClassifiction(String restaurantClassifiction) {
		RestaurantClassifiction = restaurantClassifiction;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantVO [RestaurantId=");
		builder.append(RestaurantId);
		builder.append(", RestaurantName=");
		builder.append(RestaurantName);
		builder.append(", RestaurantTelNumber=");
		builder.append(RestaurantTelNumber);
		builder.append(", RestaurantAdd=");
		builder.append(RestaurantAdd);
		builder.append(", RestaurantOwner=");
		builder.append(RestaurantOwner);
		builder.append(", RestaurantClassifiction=");
		builder.append(RestaurantClassifiction);
		builder.append("]");
		return builder.toString();
	}
	
	
}
